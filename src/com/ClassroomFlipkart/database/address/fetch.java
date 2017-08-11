package com.ClassroomFlipkart.database.address;

import com.ClassroomFlipkart.database.utils.DBUtils;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.ClassroomFlipkart.database.checkout.fetchitems.addressScroller;

public class fetch {

    public static VBox getAddress(String emailId) {

        VBox addresses = new VBox(10);
        addresses.setPadding(new Insets(0,10,10,10));

        final ToggleGroup group = new ToggleGroup();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" * ",
                " classroomflipkart.useraddress ",
                "emailId = '"+emailId+"' ",
                "ORDER BY isDefault desc");

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()){
                String address = rs.getString("userAddress");
                String isDefault = rs.getString("isDefault");

                RadioButton radio = new RadioButton(address);
                radio.setFont(Font.font("Open Sans", 15));
                if (isDefault.equals("true")){
                    radio.setText("( DEFAULT )\n "+address);
                    radio.setFont(Font.font("Open Sans", FontWeight.BOLD, 15));
                    radio.setSelected(true);
                }
                radio.setToggleGroup(group);
                radio.setWrapText(true);
                radio.setOnAction(e-> {
                    addresses.getChildren().clear();
                    markDefault.update(emailId,address);
                    addressScroller.setContent(fetch.getAddress(emailId));
                });
                addresses.getChildren().add(radio);
            }

        } catch (Exception e) {
            addresses.getChildren().add(new Label(e.getMessage()));
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return addresses;
        }
    }

}
