package testPackage.service;

import testPackage.service.data.GuiGroup;

import java.util.List;

/**
 * Интерефейс прикладной логики ClientManagerImpl
 */
public interface ClientManager {
    /**
     * Получить перечень интерфейсов, доступных текущему пользователю
     * @return список структур данных
     */
    List<GuiGroup> getGuiList();

    /**
     * Проверяем существует ли в списке guiGroupList искомый элемент id
     * @param guiGroupList
     * @param id
     * @return элемент id
     */
    public boolean contains(List<GuiGroup> guiGroupList, String id);
}
