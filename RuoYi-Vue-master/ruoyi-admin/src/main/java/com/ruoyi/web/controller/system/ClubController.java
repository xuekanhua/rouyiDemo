package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.service.IMessageService;
import com.ruoyi.system.service.IUserClubService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Club;
import com.ruoyi.system.service.IClubService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社团管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@RestController
@RequestMapping("/system/club")
public class ClubController extends BaseController
{
    @Autowired
    private IClubService clubService;

    @Autowired
    private IUserClubService userClubService;

    @Autowired
    private IMessageService messageService;

    /**
     * 查询社团管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:club:list')")
    @GetMapping("/list")
    public TableDataInfo list(Club club)
    {
        startPage();
        List<Club> list = clubService.selectClubList(club);
        return getDataTable(list);
    }

    /**
     * 导出社团管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:club:export')")
    @Log(title = "社团管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Club club)
    {
        List<Club> list = clubService.selectClubList(club);
        ExcelUtil<Club> util = new ExcelUtil<Club>(Club.class);
        util.exportExcel(response, list, "社团管理数据");
    }

    /**
     * 获取社团管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:club:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(clubService.selectClubById(id));
    }

    /**
     * 新增社团管理
     */
    @PreAuthorize("@ss.hasPermi('system:club:add')")
    @Log(title = "社团管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Club club)
    {
        return toAjax(clubService.insertClub(club));
    }

    /**
     * 修改社团管理
     */
    @PreAuthorize("@ss.hasPermi('system:club:edit')")
    @Log(title = "社团管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Club club)
    {
        return toAjax(clubService.updateClub(club));
    }

    /**
     * 删除社团管理
     * 社团内成员清零 delete user_club where club_id (表里没有deleted)
     * 文章清零 update message deleted=1 where club_id
     */
    @PreAuthorize("@ss.hasPermi('system:club:remove')")
    @Log(title = "社团管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        userClubService.updateUserClubByClubIds(ids);
        messageService.updateMessageByClubIds(ids);

        return toAjax(clubService.deleteClubByIds(ids));
    }
}
