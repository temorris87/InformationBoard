package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller {

  @FXML TextField caName;
  @FXML TextField caVisOne;
  @FXML TextField caVisTwo;
  @FXML CheckBox cbcaService;
  @FXML TextField caServiceLocation;
  @FXML TextField caFHTime;
  @FXML TextField caChurchService;
  @FXML ChoiceBox<Location> caChurches;
  @FXML TextField caChurchTime;
  @FXML TextField caCemeteryService;
  @FXML ChoiceBox<Location> caCemeteries;
  @FXML TextField caCemeteryTime;
  @FXML CheckBox cbcaDonation;
  @FXML RadioButton rbcaMale;
  @FXML RadioButton rbcaFemale;
  @FXML TextField caDonationFoundation;
  @FXML TextField caDonationWebsite;

  @FXML TextField cbName;
  @FXML TextField cbVisOne;
  @FXML TextField cbVisTwo;
  @FXML CheckBox cbcbService;
  @FXML TextField cbServiceLocation;
  @FXML TextField cbFHTime;
  @FXML TextField cbChurchService;
  @FXML ChoiceBox<Location> cbChurches;
  @FXML TextField cbChurchTime;
  @FXML TextField cbCemeteryService;
  @FXML ChoiceBox<Location> cbCemeteries;
  @FXML TextField cbCemeteryTime;
  @FXML CheckBox cbcbDonation;
  @FXML RadioButton rbcbMale;
  @FXML RadioButton rbcbFemale;
  @FXML TextField cbDonationFoundation;
  @FXML TextField cbDonationWebsite;

  @FXML TextField ccName;
  @FXML TextField ccVisOne;
  @FXML TextField ccVisTwo;
  @FXML CheckBox cbccService;
  @FXML TextField ccServiceLocation;
  @FXML TextField ccFHTime;
  @FXML TextField ccChurchService;
  @FXML ChoiceBox<Location> ccChurches;
  @FXML TextField ccChurchTime;
  @FXML TextField ccCemeteryService;
  @FXML ChoiceBox<Location> ccCemeteries;
  @FXML TextField ccCemeteryTime;
  @FXML CheckBox cbccDonation;
  @FXML RadioButton rbccMale;
  @FXML RadioButton rbccFemale;
  @FXML TextField ccDonationFoundation;
  @FXML TextField ccDonationWebsite;

  @FXML Button btnSubmit;
  @FXML Button btncaImage;
  @FXML Button btncbImage;
  @FXML Button btnccImage;

  @FXML ImageView caimg;
  @FXML ImageView cbimg;
  @FXML ImageView ccimg;

  @FXML ChoiceBox<String> cbLoc;
  @FXML TextField locName;
  @FXML TextField locAddress;
  @FXML TextField locCity;
  @FXML TextField locState;
  @FXML TextField locZipCode;
  @FXML Button btnLoc;

  @FXML RadioButton rbChurch;
  @FXML RadioButton rbCemetery;
  @FXML ChoiceBox<Location> cbDelLoc;
  @FXML Button btnDelLoc;

  String imgALoc = "";
  String imgBLoc = "";
  String imgCLoc = "";

  String chapelAHTML = "";
  String chapelBHTML = "";
  String chapelCHTML = "";
  String dateHTML = "";

  String chapelAImgCode = "";
  String chapelBImgCode = "";
  String chapelCImgCode = "";

  public void initialize() {
    initChurches();
    initCemeteries();

    ArrayList<String> temp = new ArrayList<>();
    temp.add("Cemetery");
    temp.add("Church");
    cbLoc.setItems(FXCollections.observableList(temp));

    caServiceLocation.setText("Gosselin Funeral Home");
    cbServiceLocation.setText("Gosselin Funeral Home");
    ccServiceLocation.setText("Gosselin Funeral Home");

    //date.setValue(LocalDate.now());
  }

  public void initChurches() {
    caChurches.getItems().clear();
    cbChurches.getItems().clear();
    ccChurches.getItems().clear();
    ObservableList<Location> obList = FXCollections.observableList(Locations.getChurches());
    caChurches.setItems(FXCollections.observableArrayList(obList));
    cbChurches.setItems(FXCollections.observableArrayList(obList));
    ccChurches.setItems(FXCollections.observableArrayList(obList));


  }

  public void initCemeteries() {
    caCemeteries.getItems().clear();
    cbCemeteries.getItems().clear();
    ccCemeteries.getItems().clear();
    ObservableList<Location> obList = FXCollections.observableList(Locations.getCemeteries());
    caCemeteries.setItems(FXCollections.observableArrayList(obList));
    cbCemeteries.setItems(FXCollections.observableArrayList(obList));
    ccCemeteries.setItems(FXCollections.observableArrayList(obList));
  }

  public void testing() {
    caName.setText("Joseph Weskensky");
  }

  public void setImageA() {
    setImage(caimg);
  }

  public void setImageB() {
    setImage(cbimg);
  }

  public void setImageC() {
    setImage(ccimg);
  }

  public void setImage(ImageView iv) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select Image");
    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
    File selectedFile = fileChooser.showOpenDialog(InfoBoard.getStage());

    if (iv == caimg)
      imgALoc = selectedFile.getAbsolutePath();
    else if (iv == cbimg)
      imgBLoc = selectedFile.getAbsolutePath();
    else
      imgCLoc = selectedFile.getAbsolutePath();

    try {
      if (selectedFile != null) {
        iv.setImage(new Image(new FileInputStream(selectedFile.toString())));
        //txtImageC.setText(selectedFile.toString());
      }
    } catch (FileNotFoundException e) {

    }
  }

  public void addLocation() {
    System.out.println(cbLoc.getValue());
    if (cbLoc.getValue() == "Church") {
      System.out.println("Success!");
      Locations loc = new Locations("churches.dat");
      loc.add(locName.getText(), locAddress.getText(), locCity.getText(), locState.getText(), locZipCode.getText());
      loc.saveLocations();
      initChurches();
    }
    else {
      Locations loc = new Locations("cemeterys.dat");
      loc.add(locName.getText(), locAddress.getText(), locCity.getText(), locState.getText(), locZipCode.getText());
      loc.saveLocations();
      initCemeteries();
    }
  }

  public void delLocation() {
    if (rbChurch.isSelected()) {
      Locations loc = new Locations("churches.dat");
      loc.remove(cbDelLoc.getValue().getName());
      loc.saveLocations();
      initChurches();
    }
    else {
      Locations loc = new Locations("cemeterys.dat");
      loc.remove(cbDelLoc.getValue().getName());
      loc.saveLocations();
      initCemeteries();
    }

    updateDelLocations();
  }

  public void submit() {
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    //LocalDate dat = date.getValue();
    //dateHTML = "<h1>" + dat.getMonth() + " " + dat.getDayOfMonth() + ", " + dat.getYear() + "</h1>\n";

    writeHtmlFile();
    deletePreviousImages();
    copyImages();
  }

  public void writeHtmlFile() {
    updateAHTML();
    updateBHTML();
    updateCHTML();

    try {
      //PrintWriter writer = new PrintWriter("/Users/tysonmorris/Desktop/lobby.html", "UTF-8");
      PrintWriter writer = new PrintWriter("\\\\RASPBERRYPI\\Gosselin\\lobby.html", "UTF-8");
      //PrintWriter writer = new PrintWriter("/Volumes/Gosselin/lobby.html", "UTF-8");
      writer.print(produceAllHTML());
      writer.close();
    } catch (IOException e) { }
  }

  public void deletePreviousImages() {
    File file = new File("\\\\RASPBERRYPI\\Gosselin\\img\\");
    //File file = new File("/Users/tysonmorris/Desktop/img/");
    //File file = new File("/Volumes/Gosselin/img/");
    File[] contents = file.listFiles();
    if (contents != null)
      for (File f: contents)
        if (!f.getName().equals("logo.png")) {
          f.delete();
        }
  }

  public void copyImages() {
    if (caimg.getImage() != null)
      copyImage(imgALoc);
    if (cbimg.getImage() != null)
      copyImage(imgBLoc);
    if (ccimg.getImage() != null)
      copyImage(imgCLoc);
  }

  public void copyImage(String fileLoc) {
    try {
      //      InputStream input = new FileInputStream(txtImageA.getText());
      InputStream input = new FileInputStream(fileLoc);
      String aFileName = "img\\" + fileLoc.substring(fileLoc.lastIndexOf('\\') + 1, fileLoc.length());
      //String aFileName = "img/" + fileLoc.substring(fileLoc.lastIndexOf('/') + 1, fileLoc.length());
      OutputStream output = new FileOutputStream("\\\\RASPBERRYPI\\Gosselin\\" + aFileName);
      //OutputStream output = new FileOutputStream("/Users/tysonmorris/Desktop/" + aFileName);
      //OutputStream output = new FileOutputStream("/Volumes/Gosselin/" + aFileName);
      byte[] buf = new byte[1024];
      int bytesRead;
      while ((bytesRead = input.read(buf)) > 0) {
        output.write(buf, 0, bytesRead);
      }
      input.close();
      output.close();
    } catch (IOException e) {

    }
  }

  public void updateAHTML() {
    if (!caName.getText().equals("")) {
      String aFileName = "img/" + imgALoc.substring(imgALoc.lastIndexOf('\\') + 1, imgALoc.length());
      //String aFileName = "img/" + imgALoc.substring(imgALoc.lastIndexOf('/') + 1, imgALoc.length());
      chapelAHTML = producePersonHTML("Chapel A", caName.getText(), caVisOne.getText(), caVisTwo.getText(), cbcaService.isSelected(), caServiceLocation.getText(), caFHTime.getText(), caChurchService.getText(), caChurches.getValue(), caChurchTime.getText(), caCemeteryService.getText(), caCemeteries.getValue(), caCemeteryTime.getText(), cbcaDonation.isSelected(), rbcaMale.isSelected(), caDonationFoundation.getText(), caDonationWebsite.getText(),  aFileName, true);
    }
  }

   public void updateBHTML() {
    if (!cbName.getText().equals("")) {
      String bFileName = "img/" + imgBLoc.substring(imgBLoc.lastIndexOf('\\') + 1, imgBLoc.length());
      //String bFileName = "img/" + imgBLoc.substring(imgBLoc.lastIndexOf('/') + 1, imgBLoc.length());
      chapelBHTML = producePersonHTML("Chapel B", cbName.getText(), cbVisOne.getText(), cbVisTwo.getText(), cbcbService.isSelected(), cbServiceLocation.getText(), cbFHTime.getText(), cbChurchService.getText(), cbChurches.getValue(), cbChurchTime.getText(), cbCemeteryService.getText(), cbCemeteries.getValue(), cbCemeteryTime.getText(), cbcbDonation.isSelected(), rbcbMale.isSelected(), cbDonationFoundation.getText(), cbDonationWebsite.getText(), bFileName, false);
    }
  }

  public void updateCHTML() {
    if (!ccName.getText().equals("")) {
      String cFileName = "img/" + imgCLoc.substring(imgCLoc.lastIndexOf('\\') + 1, imgCLoc.length());
      //String cFileName = "img/" + imgCLoc.substring(imgCLoc.lastIndexOf('/') + 1, imgCLoc.length());
      chapelCHTML = producePersonHTML("Chapel C", ccName.getText(), ccVisOne.getText(), ccVisTwo.getText(), cbccService.isSelected(), ccServiceLocation.getText(), ccFHTime.getText(), ccChurchService.getText(), ccChurches.getValue(), ccChurchTime.getText(), ccCemeteryService.getText(), ccCemeteries.getValue(), ccCemeteryTime.getText(), cbccDonation.isSelected(), rbccMale.isSelected(), ccDonationFoundation.getText(), ccDonationWebsite.getText(), cFileName, true);
    }
  }

  public String producePersonHTML(String chapel, String name, String viewingOne, String viewingTwo, boolean isVisitation, String serviceLocation, String fhTime, String churchService, Location church, String churchTime, String cemeteryService, Location cemetery, String cemeteryTime, boolean donation, boolean male, String foundation, String website, String img, boolean left) {
    int chap;
    if (chapel.compareTo("Chapel A") == 0)
      chap = 0;
    else if (chapel.compareTo("Chapel B") == 0)
      chap = 1;
    else
      chap = 2;
    produceContentImage(img, donation, male, foundation, website, chap);

    String html;
    html = "      <div class=\"row vparent\">\n"
         +  produceContentHTML(chapel, name, viewingOne, viewingTwo, isVisitation, serviceLocation, fhTime, churchService, church, churchTime, cemeteryService, cemetery, cemeteryTime)
         +  "      </div>\n";

    return html;
  }

  private String produceContentHTML(String chapel, String name, String viewingOne, String viewingTwo, boolean isVisitation, String serviceLocation, String fhTime, String churchService, Location church, String churchTime, String cemeteryService, Location cemetery, String cemeteryTime) {
    String img;
    if (chapel.compareTo("Chapel A") == 0)
      img = chapelAImgCode;
    else if (chapel.compareTo("Chapel B") == 0)
      img = chapelBImgCode;
    else
      img = chapelCImgCode;
    String html;
    html = "        <div class=\"col-md-4\"><h1 class=\"name\"><span class=\"chapel\">" + chapel + "</span></div>\n<div class=\"col-md-8\"><h1 class=\"name\">" + name + "</h1></div>\n"
         + "        </div>\n"
         + "        <div class=\"row vparent content\">\n"
         + img
         + "        <div class=\"col-md-8 col-md-offset-4\">\n"
         + "          <h2 class=\"col-md-4\">Visitation:</h2>\n";

    if (!viewingOne.equals("") && !viewingTwo.equals(""))
      html += "          <h2 class=\"col-md-8 time\">" + viewingOne + "<br>" + viewingTwo + "</h2>\n";
    else if (!viewingOne.equals(""))
      html += "          <h2 class=\"col-md-8 time\">" + viewingOne + "</h2>\n";

    if (!isVisitation) {
      if (!fhTime.equals("")) {
        html += "          <h2 class=\"col-md-4\">Funeral Service:</h2>\n"
             +  "          <h2 class=\"col-md-8 time\">" + fhTime + "<br>" + serviceLocation + "</h2>\n";
      }
    }
    else {
      html += "          <h2 class=\"col-md-4\">No Service:</h2>\n"
           +  "          <h2 class=\"col-md-8 time\">" + serviceLocation + "</h2>\n";
    }

    if (church != null) {
      html += locationHTML(churchService, churchTime, church);
    }

    if (cemetery != null) {
     html += locationHTML(cemeteryService, cemeteryTime, cemetery);
    }

    html += "        </div>\n";

    return html;
  }

  public String locationHTML(String title, String time, Location loc) {
    String html = "";
      html += "          <h2 class=\"col-md-4\">" + title + ":</h2>\n";

    if (!time.equals(""))
      html += "          <h2 class=\"col-md-8 time\">" + time + "<br>";
    else
      html += "          <h2 class=\"col-md-8 time\">";

    if (loc.getName().equals("Private")) {
      html += loc.getName() + "</h2>\n";
    }
    else {
      html += loc.getName() + "<br>"
           +  loc.getStreetAddress() + "<br>"
           +  loc.getCity() + " " + loc.getState() + ", " + loc.getZipCode() + "</h2>\n";
    }

    return html;
  }

  private void produceContentImage(String img, boolean donation, boolean male, String foundation, String website, int chapel) {
    String gender;
    if (male)
      gender = "his";
    else
      gender = "her";

    String html;
    html =  "        <div class=\"col-md-4 vcenter\">\n"
         +  "          <img class=\"center-block portrait\" src=\"" + img + "\">\n";
    if (donation) {
      html += "          <p>Donations in " + gender + " loving memory can be made to:<br>"
           +  foundation + "<br>"
           +  website + "</p>";
    }
    html += "        </div>\n";

    if (chapel == 0)
      chapelAImgCode = html;
    else if (chapel == 1)
      chapelBImgCode = html;
    else
      chapelCImgCode = html;
  }

  public String produceAllHTML() {
    String html;
    html = "<!DOCTYPE HTML>\n\n"
        + "<html lang=\"en\">\n"
        + "  <head>\n"
        + "    <meta charset=\"utf-8\">\n"
        + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n\n"
        + "    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n"
        + "    <link href=\"css/nav.css\" rel=\"stylesheet\">\n"
        + "    <link href=\"https://fonts.googleapis.com/css?family=El+Messiri|Great Vibes\" rel=\"stylesheet\">\n\n"
        + "    <title>Lobby</title>\n"
        + "  </head>\n"
        + "  <body>\n"
        + "    <div class=\"center-page\">\n"
        + "    <div class=\"container\">\n";
    if (!caName.getText().equals("") && !cbName.getText().equals("") && !ccName.getText().equals("")) { }
    else {
      html += "    <img class=\"center-block logo\" src=\"img/logo.png\">\n";
    }
//        + dateHTML + "\n";
    if (!chapelAHTML.equals("")) html += chapelAHTML;
    if (!chapelBHTML.equals("")) html += chapelBHTML;
    if (!chapelCHTML.equals("")) html += chapelCHTML;
    html += "    </div>\n"
         +  "    </div>\n"
         +  "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n"
         +  "    <script src=\"javascript/bootstrap.min.js\"></script>\n"
         +  "    <script src=\"javascript/custom.js\"></script>\n"
         +  "  </body>\n"
         +  "</html>\n";
    return html;
  }

  public void updateDelLocations() {
    cbDelLoc.getItems().clear();
    ObservableList<Location> obList;
    if (rbChurch.isSelected())
      obList = FXCollections.observableList(Locations.getChurches());
    else
      obList = FXCollections.observableList(Locations.getCemeteries());
    cbDelLoc.setItems(FXCollections.observableArrayList(obList));
  }
}
