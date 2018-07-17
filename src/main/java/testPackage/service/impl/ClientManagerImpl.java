package testPackage.service.impl;

import org.springframework.stereotype.Service;
import testPackage.service.ClientManager;
import testPackage.service.data.Gui;
import testPackage.service.data.GuiGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Прикладная логика
 */
@Service
public class ClientManagerImpl implements ClientManager {

    @Override
    public List<GuiGroup> getGuiList() {
        GuiGroup guiGroup = new GuiGroup();
        List<Gui> guiList = new ArrayList<>();
        List<GuiGroup> guiGroupList = new ArrayList<>();

        Gui gui1 = new Gui();
        gui1.setGuiName("DefaultGUI");
        Gui gui2 = new Gui();
        gui2.setGuiName("DefaultGUI2");
        Gui gui3 = new Gui();
        gui3.setGuiName("DefaultGUI3");

        guiList.add(gui1);
        guiList.add(gui2);
        guiList.add(gui3);

        guiGroup.setGuiList(guiList);
        guiGroupList.add(guiGroup);

        return guiGroupList;
    }

    // Проверяем существует ли в списке искомый элемент
    public boolean contains(List<GuiGroup> guiGroupList, String id) {
        if (guiGroupList == null || id == null)
            return false;
        for (GuiGroup guiGroup : guiGroupList) {
            if (guiGroup.getGuiList() == null)
                continue;
            for (Gui gui : guiGroup.getGuiList())
                if (id.equals(gui.getGuiName()))
                    return true;
        }
        return false;
    }
}