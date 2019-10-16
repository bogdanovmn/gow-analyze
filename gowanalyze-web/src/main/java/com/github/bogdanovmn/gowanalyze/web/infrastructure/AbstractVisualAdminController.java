package com.github.bogdanovmn.gowanalyze.web.infrastructure;

import com.github.bogdanovmn.common.spring.menu.MenuItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public abstract class AbstractVisualAdminController extends AbstractVisualController {
	protected MenuItem currentMenuItem() { return MainMenuItem.NONE; }
}
