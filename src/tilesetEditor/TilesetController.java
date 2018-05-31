package tilesetEditor;

import model.Property;
import model.PropertySpecification;
import model.TileInfo;
import model.Tileset;
import tilesetEditor.properties.PropertiesChoiceWindow;
import tilesetEditor.properties.PropertiesModifyWindow;
import util.Controller;

import util.ModalWindows.ModalInfoWindow;
import util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import settings.Settings;
import settings.SettingsWindow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TilesetController extends Controller {
    @FXML // fx:id="menuFile"
    private Menu menuFile; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileNew"
    private MenuItem menuFileNew; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileOpen"
    private MenuItem menuFileOpen; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileSave"
    private MenuItem menuFileSave; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileClose"
    private MenuItem menuFileClose; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileSettings"
    private MenuItem menuFileSettings; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileQuit"
    private MenuItem menuFileQuit; // Value injected by FXMLLoader

    @FXML // fx:id="menuHelp"
    private Menu menuHelp; // Value injected by FXMLLoader

    @FXML // fx:id="menuHelpAbout"
    private MenuItem menuHelpAbout; // Value injected by FXMLLoader

    @FXML // fx:id="fileLabel"
    private Label fileLabel; // Value injected by FXMLLoader

    @FXML // fx:id="filenameLabel"
    private Label filenameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="nameLabel"
    private Label nameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="filenameField"
    private TextField filenameField; // Value injected by FXMLLoader

    @FXML // fx:id="nameField"
    private TextField nameField; // Value injected by FXMLLoader

    @FXML // fx:id="infoLabel"
    private Label infoLabel; // Value injected by FXMLLoader

    @FXML // fx:id="columnLabel"
    private Label columnLabel; // Value injected by FXMLLoader

    @FXML // fx:id="lineLabel"
    private Label lineLabel; // Value injected by FXMLLoader

    @FXML // fx:id="offsetLabel"
    private Label offsetLabel; // Value injected by FXMLLoader

    @FXML // fx:id="columnSpinner"
    private Spinner<Integer> columnSpinner; // Value injected by FXMLLoader

    @FXML // fx:id="lineSpinner"
    private Spinner<Integer> lineSpinner; // Value injected by FXMLLoader

    @FXML // fx:id="offsetSpinner"
    private Spinner<Integer> offsetSpinner; // Value injected by FXMLLoader

    @FXML // fx:id="validateButton"
    private Button validateButton; // Value injected by FXMLLoader

    @FXML // fx:id="resetButton"
    private Button resetButton; // Value injected by FXMLLoader

    @FXML // fx:id="tilesetPanel"
    private Pane tilesetPanel; // Value injected by FXMLLoader

    @FXML // fx:id="propertiesTree"
    private TreeView<String> propertiesTree; // Value injected by FXMLLoader

    private static String lastBrowse;

    private Image image;
    private GridPane grid;

    private TreeItem<String> root;
    private List<Property> properties = new ArrayList<>();

    private TileDisplay[] tiles;
    private Tileset tileset;

    private double dx;
    private double dy;

    private Selection selection;

    public void init() {
        selection = new Selection(-1, -1);

        root = new TreeItem("ROOT");
        propertiesTree.setRoot(root);
        propertiesTree.showRootProperty().setValue(false);

        propertiesTree.getSelectionModel().selectedItemProperty().addListener(e -> {
            TreeItem<String> selected = propertiesTree.getSelectionModel().getSelectedItem();

            if (selected == null) {
                selection.iProp = -1;
                selection.iSpec = -1;

                for (TileDisplay td : tiles)
                    td.displayNoPropertie();

                return;
            }

            if (selected.getParent() != root) {
                selection.iSpec = selected.getParent().getChildren().indexOf(selected);
                selected = selected.getParent();
                selection.iProp = selected.getParent().getChildren().indexOf(selected);
            } else {
                selection.iProp = selected.getParent().getChildren().indexOf(selected);
                selection.iSpec = -1;
            }

            if (tiles != null)
                for (TileDisplay td : tiles)
                    td.displayPropertie(properties.get(selection.iProp));


            /*for (TreeItem<String> ti : selection.getParent().getChildren())
                ti.setExpanded(ti == selection);*/
        });

        tilesetPanel.setOnMouseClicked(e -> actualizeTiles());
        tilesetPanel.setOnMouseDragged(e -> actualizeTiles());
    }

    private void actualizeTiles() {
        if (selection.iProp != -1 && tiles != null)
            for (TileDisplay td : tiles)
                td.displayPropertie(properties.get(selection.iProp));
    }

    private void sizeImageToPane() {
        dx = image.getWidth() / tilesetPanel.getWidth();
        dy = image.getHeight() / tilesetPanel.getHeight();

        ImageView imagePanel = new ImageView();
        imagePanel.setPreserveRatio(true);

        double x;
        double y;
        double width;
        double height;

        if (dx > dy) {
            x = 0;
            y = (tilesetPanel.getHeight() - image.getHeight() / dx) / 2;
            width = tilesetPanel.getWidth();
            height = image.getHeight() / dx;

            imagePanel.setFitWidth(width);
        } else {
            x = (tilesetPanel.getWidth() - image.getWidth() / dy) / 2;
            y = 0;
            width = image.getWidth() / dy;
            height = tilesetPanel.getHeight();

            imagePanel.setFitHeight(height);
        }

        if (grid != null)
            tilesetPanel.getChildren().clear();

        grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setTranslateX(x);
        grid.setTranslateY(y);

        grid.setMinWidth(width);
        grid.setMaxWidth(width);
        grid.setPrefWidth(width);

        grid.setMinHeight(height);
        grid.setMaxHeight(height);
        grid.setPrefHeight(height);

        tilesetPanel.getChildren().add(grid);
    }

    private void divideImage() {
        grid.getChildren().clear();
        grid.setVgap(1);
        grid.setHgap(1);

        if (dx > dy)
            grid.setTranslateY((tilesetPanel.getHeight() - image.getHeight() / dx) / 2);
        else
            grid.setTranslateX((tilesetPanel.getWidth() - image.getWidth() / dy) / 2);

        int cols = columnSpinner.getValue();
        int lines = lineSpinner.getValue();
        int offset = offsetSpinner.getValue();

        int width = ((int)image.getWidth() - offset) / cols - offset;
        int height = ((int)image.getHeight() - offset) / lines - offset;

        double fitW = (grid.getWidth() - grid.getHgap() * (cols + 1)) / cols;
        double fitH = (grid.getHeight() - grid.getVgap() * (lines + 1)) / lines;

        tiles = new TileDisplay[cols * lines];

        for (int i = 0; i < cols; ++i) {
            for (int j = 0; j < lines; ++j) {
                int offX = offset + i * (width + offset);
                int offY = offset + j * (height + offset);
                Image img = Util.subimage(image, offX, offY, width, height);

                TileDisplay td = new TileDisplay(img, selection, fitW, fitH);
                tiles[i + j * cols] = td;

                grid.add(td, i, j);
            }
        }

        for (TileDisplay td : tiles)
            for (int i = 0; i < properties.size(); ++i)
                td.addProperty();

        grid.setGridLinesVisible(true);
    }

    private void loadImageFile() {
        FileChooser fc = new FileChooser();
        fc.setTitle(Settings.language.getWord("tilesetBrowse"));
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"));

        if (lastBrowse != null)
            fc.setInitialDirectory(new File(lastBrowse));

        File file = fc.showOpenDialog(TilesetWindow.INSTANCE.getStage());

        if (file != null) {
            filenameField.setText(file.getAbsolutePath());
            lastBrowse = file.getParent();

            tilesetPanel.getChildren().clear();
            image = new Image("file:" + file.getAbsolutePath());

            sizeImageToPane();

            columnSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, (int)image.getWidth(), 1));
            lineSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, (int)image.getHeight(), 1));
            offsetSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));

            divideImage();
        }
    }

    @FXML
    void aboutClicked(ActionEvent event) {

    }

    @FXML
    void addClicked(ActionEvent event) {
        PropertiesChoiceWindow choice = new PropertiesChoiceWindow();
        choice.start();

        Property prop = choice.getProp();

        if (prop != null && !prop.getName().equals("")) {
            properties.add(prop);

            TreeItem<String> item = new TreeItem<>(prop.getName());
            root.getChildren().add(item);

            for (PropertySpecification ps : (List<PropertySpecification>)prop.getSpecif()) {
                TreeItem specs = new TreeItem(ps.getName(), Util.coloredSquare(ps.getColor()));

                item.getChildren().add(specs);
            }


            if (tiles != null)
                for (TileDisplay td : tiles)
                    td.addProperty();
        }
    }

    @FXML
    void closeClicked(ActionEvent event) {
        filenameField.setText("");
        nameField.setText("");

        // EXCEPTION HERE IS NO PROBLEM
        SpinnerValueFactory factory = columnSpinner.getValueFactory();
        try {
            factory.setValue(null);
        } catch (Exception e) {}
        factory = lineSpinner.getValueFactory();
        try {
            factory.setValue(null);
        } catch (Exception e) {}
        factory = offsetSpinner.getValueFactory();
        try {
            factory.setValue(null);
        } catch (Exception e) {}
        // END OF ACCEPTED EXCEPTION

        columnSpinner.setValueFactory(null);
        lineSpinner.setValueFactory(null);
        offsetSpinner.setValueFactory(null);

        tilesetPanel.getChildren().clear();
    }

    @FXML
    void exportClicked(ActionEvent event) {
        if (properties.size() == 0) {
            new ModalInfoWindow(Settings.language.getWord("propertiesExportErrorTitle"), Settings.language.getWord("propertiesExportErrorText"));
            return;
        }
        File file = getPropsFile(Settings.language.getWord("propertiesBrowseExport"));

    }

    @FXML
    void filenameButtonClicked(ActionEvent event) {
        loadImageFile();
    }

    @FXML
    void importClicked(ActionEvent event) {
        File file = getPropsFile(Settings.language.getWord("propertiesBrowseImport"));

        if (file != null) {
            List<Property> loadedprops = null;

            properties = loadedprops;

            if (tiles != null)
                for (TileDisplay td : tiles)
                    for (Property p : properties)
                        td.addProperty();
        }
    }

    public File getPropsFile(String title) {
        FileChooser fc = new FileChooser();
        fc.setTitle(title);
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Tileset", "*.tls"));

        if (lastBrowse != null)
            fc.setInitialDirectory(new File(lastBrowse));

        File file = fc.showOpenDialog(TilesetWindow.INSTANCE.getStage());

        if (file != null)
            lastBrowse = file.getParent();
        return file;
    }

    @FXML
    void modifiyClicked(ActionEvent event) {
        TreeItem<String> ti = propertiesTree.getSelectionModel().getSelectedItem();

        if (ti == null)
            return;

        if (!ti.getParent().equals(root))
            ti = ti.getParent();
        propertiesTree.getSelectionModel().select(ti);

        Property p = properties.get(ti.getParent().getChildren().indexOf(ti));

        PropertiesModifyWindow modifier = new PropertiesModifyWindow(p.getType());
        modifier.start(p);

        ti.setValue(p.getName());
        ti.getChildren().clear();

        for (PropertySpecification ps : (List<PropertySpecification>)p.getSpecif()) {
            TreeItem specs = new TreeItem(ps.getName(), Util.coloredSquare(ps.getColor()));

            ti.getChildren().add(specs);
        }

        List<Integer> remove = modifier.getRemove();

        for (TileDisplay td : tiles)
            for (Integer i : remove)
                td.removeSpec(ti.getParent().getChildren().indexOf(ti), i);
        actualizeTiles();
    }

    @FXML
    void newClicked(ActionEvent event) {
        closeClicked(event);
        loadImageFile();
    }

    @FXML
    void openClicked(ActionEvent event) {
        if (!Settings.checkDirectory())
            return;

    }

    @FXML
    void quitClicked(ActionEvent event) {
        TilesetWindow.INSTANCE.close();
    }

    @FXML
    void removeClicked(ActionEvent event) {
        TreeItem<String> ti = propertiesTree.getSelectionModel().getSelectedItem();

        if (ti == null)
            return;

        if (ti.getParent().equals(root)) {
            // PROPERTY
            properties.remove(root.getChildren().indexOf(ti));
            for (TileDisplay td : tiles)
                td.removeProperty(ti.getParent().getChildren().indexOf(ti));
            ti.getParent().getChildren().remove(ti);
        } else {
            // SPECIFICATION
            Property p = properties.get(root.getChildren().indexOf(ti.getParent()));

            if (p != null) {
                p.getSpecif().remove(ti.getParent().getChildren().indexOf(ti));
                TreeItem<String> parent = ti.getParent();
                ti.getParent().getChildren().remove(ti);

                if (p.getSpecif().size() == 0) {
                    properties.remove(p);
                    for (TileDisplay td : tiles)
                        td.removeProperty(parent.getParent().getChildren().indexOf(parent));
                    parent.getParent().getChildren().remove(parent);
                }
            }
        }
    }

    @FXML
    void saveClicked(ActionEvent event) {
        if (nameField.getText().equals("")) {
            new ModalInfoWindow(Settings.language.getWord("tilesetNameErrorTitle"), Settings.language.getWord("tilesetNameErrorText"));
            return;
        }
        if (!Settings.checkDirectory())
            return;

        updateTileset();
    }

    public void updateTileset() {
        TileInfo[] tmp = new TileInfo[tiles.length];

        for (int i = 0; i < tmp.length; ++i)
            tmp[i] = new TileInfo(tiles[i].getProps());

        tileset = new Tileset(image, nameField.getText(), columnSpinner.getValue(), lineSpinner.getValue(), offsetSpinner.getValue(), properties, tmp);
    }

    @FXML
    void settingsClicked(ActionEvent event) {
        SettingsWindow.launchWindow();
    }

    @FXML
    void validateClicked(ActionEvent event) {
        divideImage();
        updateTileset();
    }

    @FXML
    void resetClicked(ActionEvent event) {
        rollbackTileset();
    }

    public void rollbackTileset() {
        if (tileset == null)
            return;

        image = tileset.getImage();
        nameField.setText(tileset.getName());

        columnSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, (int)image.getWidth(), tileset.getColumns()));
        lineSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, (int)image.getHeight(), tileset.getRows()));
        offsetSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, tileset.getOffset()));

        divideImage();

        properties = new ArrayList<>();

        for (Property p : tileset.getProps())
            properties.add(new Property(p));

        for (int i = 0; i < tiles.length; ++i)
            tiles[i].setProps(tileset.getTiles()[i].getProps());
    }

    @Override
    protected void languageChanged() {
        menuFile.setText(Settings.language.getWord("menuFile"));
        menuFileNew.setText(Settings.language.getWord("menuFileNew"));
        menuFileOpen.setText(Settings.language.getWord("menuFileOpen"));
        menuFileSave.setText(Settings.language.getWord("menuFileSave"));
        menuFileClose.setText(Settings.language.getWord("menuFileClose"));
        menuFileSettings.setText(Settings.language.getWord("menuFileSettings"));
        menuFileQuit.setText(Settings.language.getWord("menuFileQuit"));

        menuHelp.setText(Settings.language.getWord("menuHelp"));
        menuHelpAbout.setText(Settings.language.getWord("menuHelpAbout"));

        fileLabel.setText(Settings.language.getWord("tilesetFileLabel"));
        filenameLabel.setText(Settings.language.getWord("tilesetFilenameLabel") + " :");
        nameLabel.setText(Settings.language.getWord("tilesetNameLabel") + " :");
        infoLabel.setText(Settings.language.getWord("tilesetInfoLabel"));
        columnLabel.setText(Settings.language.getWord("tilesetColumnLabel") + " :");
        lineLabel.setText(Settings.language.getWord("tilesetLineLabel") + " :");
        offsetLabel.setText(Settings.language.getWord("tilesetOffsetLabel") + " :");

        validateButton.setText(Settings.language.getWord("tilesetValidateButton"));
        resetButton.setText(Settings.language.getWord("tilesetResetButton"));
    }
}
