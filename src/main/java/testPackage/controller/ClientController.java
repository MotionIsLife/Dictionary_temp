package testPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;
import testPackage.service.ClientManager;
import testPackage.service.data.GuiGroup;

import java.util.List;

/**
 * Модуль "Управление интерфейсом". MVC-контроллер (построение основного экрана приложения).
 */
@Controller
public class ClientController {
    @Autowired
    private ClientManager clientManager;

    private final static String DEFAULT_GUI = "DefaultGUI";

    @RequestMapping(value = "/client/modules", method = RequestMethod.GET)
    public ModelAndView openGuiDefault() {
        return openGuiById(DEFAULT_GUI);
    }

    @RequestMapping(value = "/client/modules/{id}", method = RequestMethod.GET)
    public ModelAndView openGuiById(@ModelAttribute("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        List<GuiGroup> guiGroupList = clientManager.getGuiList();
        boolean pageFound = clientManager.contains(guiGroupList, id);
        final String pageId = (id != null) ? id : DEFAULT_GUI;
        if (!pageFound) throw new HttpServerErrorException(HttpStatus.NOT_FOUND);//RuntimeException("404");
        modelAndView.setViewName("ClientScreen");
        modelAndView.addObject("page", pageId + ".jsp");
        modelAndView.addObject("guiList", guiGroupList);
        return modelAndView;
    }
}