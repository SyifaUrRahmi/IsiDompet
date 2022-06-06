package com.dompet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class App extends Application {

    private int Pemasukan;
    private int NewPemasukan;
    private int Maximum;
    private int Batas;
    private int RiwayatPemasukan;
    private String DaftarPengeluaran;
    private int RiwayatPengeluaran;
    private String datePickerIn;
    private String datePickerOut;

    @Override
    public void start(Stage apkStage) {

        int spacing = 20;

        Text sambutan = new Text("Selamat Datang di Aplikasi");
        sambutan.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 50));
        sambutan.setFill(Color.ROYALBLUE);

        Text apk = new Text("IsiDompet");
        apk.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 50));
        apk.setFill(Color.ROYALBLUE);

        Label Nama = new Label("Masukkan Nama Pengguna");
        Nama.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));

        TextField textFieldNama = new TextField();
        textFieldNama.setMaxWidth(200.0);
        textFieldNama.setAlignment(Pos.CENTER);

        Label labelErorAlphabet = new Label("Alphabet Only");
        labelErorAlphabet.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
        labelErorAlphabet.setTextFill(Color.RED);
        labelErorAlphabet.setVisible(false);

        textFieldNama.textProperty().addListener((observable, oldValue, newValue) -> {
            labelErorAlphabet.setVisible(!newValue.matches("[a-z A-Z]+") && !newValue.isEmpty());
        });

        Button masuk = new Button("Masuk");
        masuk.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        masuk.setTextFill(Color.WHITE);
        masuk.setBackground(new Background(
                new BackgroundFill(Color.ROYALBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        VBox vBox = new VBox(spacing);
        vBox.getChildren().addAll(sambutan, apk, Nama, textFieldNama, labelErorAlphabet, masuk);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 700, 700);
        apkStage.setScene(scene);
        apkStage.show();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                Text firstText = new Text("\nIsiDompet");
                firstText.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 50));
                firstText.setFill(Color.ROYALBLUE);

                Text namaText = new Text(textFieldNama.getText());
                namaText.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 25));

                Text isi = new Text("Rp. " + Pemasukan);
                isi.setFont(Font.font("comic sans", FontWeight.BOLD, FontPosture.REGULAR, 40));

                Text batas = new Text("Maksimal Pengeluaran Rp. " + Batas);
                batas.setFont(Font.font("comic sans", FontWeight.BOLD, FontPosture.REGULAR, 20));

                Text notif = new Text("");

                notif.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 25));
                notif.setFill(Color.RED);

                final ToggleGroup group = new ToggleGroup();

                ToggleButton tb1 = new ToggleButton("Pemasukan");
                tb1.setToggleGroup(group);
                tb1.setPrefSize(200, 35);
                tb1.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                tb1.setTextFill(Color.WHITE);
                tb1.setSelected(true);
                tb1.setBackground(new Background(
                        new BackgroundFill(Color.ROYALBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

                ToggleButton tb2 = new ToggleButton("Pengaturan Dompet");
                tb2.setToggleGroup(group);
                tb2.setPrefSize(200, 35);
                tb2.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                tb2.setTextFill(Color.WHITE);
                tb2.setSelected(true);
                tb2.setBackground(new Background(
                        new BackgroundFill(Color.ROYALBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

                ToggleButton tb3 = new ToggleButton("Pengeluaran");
                tb3.setToggleGroup(group);
                tb3.setPrefSize(200, 35);
                tb3.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                tb3.setTextFill(Color.WHITE);
                tb3.setSelected(true);
                tb3.setBackground(new Background(
                        new BackgroundFill(Color.ROYALBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

                ToggleButton tb4 = new ToggleButton("Riwayat");
                tb4.setToggleGroup(group);
                tb4.setPrefSize(200, 35);
                tb4.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                tb4.setTextFill(Color.WHITE);
                tb4.setSelected(true);
                tb4.setBackground(new Background(
                        new BackgroundFill(Color.ROYALBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                VBox vBox = new VBox(spacing);
                vBox.getChildren().addAll(firstText, namaText, isi, batas, notif, tb1, tb2, tb3,
                        tb4);
                vBox.setAlignment(Pos.TOP_CENTER);
                Scene scene2 = new Scene(vBox, 700, 700);
                apkStage.setScene(scene2);
                apkStage.show();

                EventHandler<ActionEvent> eventA = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {

                        GridPane grid = new GridPane();
                        grid.setAlignment(Pos.CENTER);

                        grid.setHgap(10);
                        grid.setVgap(10);
                        grid.setPadding(new Insets(5, 5, 5, 5));
                        Scene scene3 = new Scene(grid, 700, 700);
                        apkStage.setScene(scene3);

                        Label tanggal = new Label("Tanggal");
                        tanggal.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                        grid.add(tanggal, 0, 1);

                        TextField textFieldDate = new TextField();
                        DatePicker datePicker = new DatePicker();
                        GridPane.setHalignment(textFieldDate, HPos.LEFT);
                        grid.add(datePicker, 1, 1);

                        Label pemasukan = new Label("Jumlah Pemasukan");
                        pemasukan.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                        grid.add(pemasukan, 0, 2);

                        TextField textFieldPemasukan = new TextField();
                        grid.add(textFieldPemasukan, 1, 2);

                        Label labelErorNumber = new Label("Number Only");
                        grid.add(labelErorNumber, 2, 2);
                        labelErorNumber.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        labelErorNumber.setTextFill(Color.RED);
                        labelErorNumber.setVisible(false);

                        textFieldPemasukan.textProperty()
                                .addListener((observable, oldValue, newValue) -> {
                                    labelErorNumber.setVisible(
                                            !newValue.matches("\\d+") && !newValue.isEmpty());
                                });

                        Button simpan1 = new Button("Simpan");
                        simpan1.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        simpan1.setTextFill(Color.WHITE);
                        simpan1.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE,
                                CornerRadii.EMPTY, Insets.EMPTY)));
                        grid.add(simpan1, 2, 3);

                        Button kembali1 = new Button("Kembali");
                        kembali1.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        kembali1.setTextFill(Color.WHITE);
                        kembali1.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE,
                                CornerRadii.EMPTY, Insets.EMPTY)));
                        grid.add(kembali1, 2, 4);
                        apkStage.show();

                        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {

                                datePickerIn = String.valueOf(datePicker.getValue());
                                App.this.RiwayatPemasukan =
                                        Integer.parseInt(textFieldPemasukan.getText());

                                Text text1 = new Text("Tanggal " + datePickerIn
                                        + "\nJumlah Pemasukan " + App.this.RiwayatPemasukan);
                                text1.setFont(Font.font("calibri", FontWeight.BOLD,
                                        FontPosture.REGULAR, 20));
                                grid.add(text1, 0, 5);

                                Button ok1 = new Button("Ok");
                                ok1.setFont(Font.font("calibri", FontWeight.BOLD,
                                        FontPosture.REGULAR, 15));
                                ok1.setTextFill(Color.WHITE);
                                ok1.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE,
                                        CornerRadii.EMPTY, Insets.EMPTY)));
                                grid.add(ok1, 1, 6);

                                EventHandler<ActionEvent> eventOk1 =
                                        new EventHandler<ActionEvent>() {
                                            public void handle(ActionEvent e) {

                                                App.this.Pemasukan =
                                                        App.this.Pemasukan + RiwayatPemasukan;
                                                isi.setText("Rp. "
                                                        + Integer.toString(App.this.Pemasukan));

                                                apkStage.setScene(scene2);
                                            }
                                        };

                                ok1.setOnAction(eventOk1);

                            }
                        };
                        simpan1.setOnAction(event1);

                        EventHandler<ActionEvent> eventKembali1 = new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                apkStage.setScene(scene2);
                            }
                        };
                        kembali1.setOnAction(eventKembali1);

                    }
                };
                tb1.setOnAction(eventA);

                EventHandler<ActionEvent> eventB = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {

                        GridPane grid = new GridPane();
                        grid.setAlignment(Pos.CENTER);
                        grid.setHgap(10);
                        grid.setVgap(10);
                        grid.setPadding(new Insets(5, 5, 5, 5));

                        Label rentang = new Label("Isi Dompetku harus cukup untuk");
                        rentang.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                        grid.add(rentang, 0, 0);

                        TextField textFieldDay = new TextField();
                        grid.add(textFieldDay, 1, 0);
                        textFieldDay.setMaxWidth(35.0);

                        Label labelErorNumber = new Label("Number Only");
                        grid.add(labelErorNumber, 3, 0);
                        labelErorNumber.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        labelErorNumber.setTextFill(Color.RED);
                        labelErorNumber.setVisible(false);

                        textFieldDay.textProperty()
                                .addListener((observable, oldValue, newValue) -> {
                                    labelErorNumber.setVisible(
                                            !newValue.matches("\\d+") && !newValue.isEmpty());
                                });

                        Label hari = new Label("Hari");
                        hari.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                        grid.add(hari, 2, 0);

                        Button simpan2 = new Button("Simpan");
                        simpan2.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        simpan2.setTextFill(Color.WHITE);
                        simpan2.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE,
                                CornerRadii.EMPTY, Insets.EMPTY)));
                        grid.add(simpan2, 3, 3);

                        Button kembali2 = new Button("Kembali");
                        kembali2.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        kembali2.setTextFill(Color.WHITE);
                        kembali2.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE,
                                CornerRadii.EMPTY, Insets.EMPTY)));
                        grid.add(kembali2, 3, 4);

                        Scene scene5 = new Scene(grid, 700, 700);
                        apkStage.setScene(scene5);
                        apkStage.show();

                        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {

                                Maximum = Integer.parseInt(textFieldDay.getText());

                                App.this.NewPemasukan = App.this.Pemasukan / Maximum;
                                batas.setText("Maksimal Pengeluaran Rp. "
                                        + Integer.toString(App.this.NewPemasukan + Batas));

                                apkStage.setScene(scene2);

                            }
                        };
                        simpan2.setOnAction(event2);

                        EventHandler<ActionEvent> eventKembali2 = new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {

                                apkStage.setScene(scene2);

                            }
                        };
                        kembali2.setOnAction(eventKembali2);

                    }
                };
                tb2.setOnAction(eventB);

                EventHandler<ActionEvent> eventC = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {

                        GridPane grid = new GridPane();
                        grid.setAlignment(Pos.CENTER);
                        grid.setHgap(10);
                        grid.setVgap(10);
                        grid.setPadding(new Insets(5, 5, 5, 5));

                        Label tanggal = new Label("Tanggal");
                        tanggal.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                        grid.add(tanggal, 0, 0);

                        TextField textFieldDate = new TextField();
                        DatePicker datePicker2 = new DatePicker();
                        GridPane.setHalignment(textFieldDate, HPos.LEFT);
                        grid.add(datePicker2, 1, 0);

                        Label pengeluaran = new Label("Daftar" + "\npengeluaran" + "\n ");
                        pengeluaran.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                        grid.add(pengeluaran, 0, 1);

                        TextArea textFieldPengeluaran = new TextArea();
                        grid.add(textFieldPengeluaran, 1, 1);
                        textFieldPengeluaran.setPrefSize(100, 200);

                        Label tpengeluaran = new Label("Total pengeluaran");
                        tpengeluaran.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                        grid.add(tpengeluaran, 0, 3);

                        TextField textFieldTPengeluaran = new TextField();
                        grid.add(textFieldTPengeluaran, 1, 3);

                        Label labelErorNumber = new Label("Number Only");
                        grid.add(labelErorNumber, 2, 3);
                        labelErorNumber.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        labelErorNumber.setTextFill(Color.RED);
                        labelErorNumber.setVisible(false);

                        textFieldTPengeluaran.textProperty()
                                .addListener((observable, oldValue, newValue) -> {
                                    labelErorNumber.setVisible(
                                            !newValue.matches("\\d+") && !newValue.isEmpty());
                                });

                        Button simpan3 = new Button("Simpan");
                        simpan3.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        simpan3.setTextFill(Color.WHITE);
                        simpan3.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE,
                                CornerRadii.EMPTY, Insets.EMPTY)));
                        grid.add(simpan3, 2, 5);

                        Button kembali3 = new Button("Kembali");
                        kembali3.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        kembali3.setTextFill(Color.WHITE);
                        kembali3.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE,
                                CornerRadii.EMPTY, Insets.EMPTY)));
                        grid.add(kembali3, 2, 6);

                        Scene scene4 = new Scene(grid, 700, 700);
                        apkStage.setScene(scene4);
                        apkStage.show();

                        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {

                                datePickerOut = String.valueOf(datePicker2.getValue());
                                DaftarPengeluaran = String.valueOf(textFieldPengeluaran.getText());
                                RiwayatPengeluaran =
                                        Integer.parseInt(textFieldTPengeluaran.getText());

                                Text text1 = new Text("Tanggal " + datePickerOut
                                        + "\nDaftar pengeluaran \n" + DaftarPengeluaran
                                        + "\nTotal Pengeluaran " + RiwayatPengeluaran);
                                text1.setFont(Font.font("calibri", FontWeight.BOLD,
                                        FontPosture.REGULAR, 20));
                                grid.add(text1, 0, 7);

                                Button ok3 = new Button("Ok");
                                ok3.setFont(Font.font("calibri", FontWeight.BOLD,
                                        FontPosture.REGULAR, 15));
                                ok3.setTextFill(Color.WHITE);
                                ok3.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE,
                                        CornerRadii.EMPTY, Insets.EMPTY)));
                                grid.add(ok3, 1, 8);

                                EventHandler<ActionEvent> eventOk3 =
                                        new EventHandler<ActionEvent>() {
                                            public void handle(ActionEvent e) {

                                                App.this.Pemasukan =
                                                        App.this.Pemasukan - RiwayatPengeluaran;
                                                isi.setText("Rp. "
                                                        + Integer.toString(App.this.Pemasukan));

                                                if (RiwayatPengeluaran > NewPemasukan) {
                                                    notif.setText(
                                                            "Anda Harus Berhemat di Hari Berikutnya");

                                                } else {
                                                    notif.setText("");
                                                }

                                                apkStage.setScene(scene2);

                                            }
                                        };
                                ok3.setOnAction(eventOk3);

                            }
                        };
                        simpan3.setOnAction(event3);

                        EventHandler<ActionEvent> eventKembali3 = new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {

                                apkStage.setScene(scene2);

                            }
                        };
                        kembali3.setOnAction(eventKembali3);

                    }
                };
                tb3.setOnAction(eventC);

                EventHandler<ActionEvent> eventD = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {

                        GridPane grid = new GridPane();
                        grid.setAlignment(Pos.CENTER);
                        grid.setHgap(10);
                        grid.setVgap(10);
                        grid.setPadding(new Insets(5, 5, 5, 5));

                        Text textRiwayatPemasukan =
                                new Text("Riwayat Pemasukan" + "\n" + "\nTanggal " + datePickerIn
                                        + "\nJumlah Pemasukan Rp. " + RiwayatPemasukan + "\n");
                        grid.add(textRiwayatPemasukan, 0, 0);
                        textRiwayatPemasukan.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));

                        Text textRiwayatPengeluaran =
                                new Text("Riwayat Pengeluaran" + "\n" + "\nTanggal " + datePickerOut
                                        + "\nDaftar pengeluaran \n" + DaftarPengeluaran
                                        + "\nTotal Pengeluaran Rp. " + RiwayatPengeluaran);
                        textRiwayatPengeluaran.setFont(
                                Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
                        grid.add(textRiwayatPengeluaran, 0, 1);

                        Button ok4 = new Button("Ok");
                        ok4.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        ok4.setTextFill(Color.WHITE);
                        ok4.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE,
                                CornerRadii.EMPTY, Insets.EMPTY)));
                        grid.add(ok4, 1, 8);
                        Scene scene4 = new Scene(grid, 700, 700);
                        apkStage.setScene(scene4);
                        apkStage.show();

                        EventHandler<ActionEvent> eventOk4 = new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {

                                apkStage.setScene(scene2);

                            }
                        };
                        ok4.setOnAction(eventOk4);

                    }
                };
                tb4.setOnAction(eventD);

            }
        };
        masuk.setOnAction(event);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


// IsiDompet
// Kelompok 8
// Syifa Ur Rahmi
// Muhammad Fikri
