package com.okta.developer.notes.backend

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

@Controller
class RouteController {
    @RequestMapping(value = ["/{path:[^\\.]*}"])
    fun redirect(req: HttpServletRequest) = "forward:/"
}