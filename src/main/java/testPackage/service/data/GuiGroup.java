package testPackage.service.data;

import java.util.List;

/**
 * Группа интерфейсов
 */
public class GuiGroup {
  private String groupId;
  private String groupName;
  private String iconUri;
  private List<Gui> guiList;

  public GuiGroup(List<Gui> guiList) {
    this.guiList = guiList;
  }

  public GuiGroup() {

  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getIconUri() {
    return iconUri;
  }

  public void setIconUri(String iconUri) {
    this.iconUri = iconUri;
  }

  public List<Gui> getGuiList() {
    return guiList;
  }

  public void setGuiList(List<Gui> guiList) {
    this.guiList = guiList;
  }
}
