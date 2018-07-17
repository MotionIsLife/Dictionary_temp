package testPackage.service.data;

import java.util.List;

/**
 * Описание прикладного интерфейса
 */
public class Gui {
  private String guiId;
  private String guiName;
  private List<String> roles;

  public Gui(List<String> roles) {
    this.roles = roles;
  }

  public Gui() {

  }

  public Gui(String guiId, String guiName, List<String> roles) {
    this.guiId = guiId;
    this.guiName = guiName;
    this.roles = roles;
  }

  public String getGuiId() {
    return guiId;
  }

  public void setGuiId(String guiId) {
    this.guiId = guiId;
  }

  public String getGuiName() {
    return guiName;
  }

  public void setGuiName(String guiName) {
    this.guiName = guiName;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }
}
