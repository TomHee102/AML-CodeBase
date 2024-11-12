package com.aml.database.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.database.DBUtil;
import com.aml.database.Entity.Media;
import com.aml.database.Repository.MediaRepo;

@Service
public class MediaService implements MediaRepo{

    @Autowired
    static List<Media> mediaList = new ArrayList();

    Connection connection;

    public MediaService() throws SQLException
    {
        connection = DBUtil.getConnection();
    }

    @Override
    public List<Media> getMediaData() 
    {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM MEDIA");
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                Media med = new Media();
                med.setId(rs.getInt(1));
                med.setAuthor(rs.getString(2));
                med.setTitle(rs.getString(3));
                med.setYear(rs.getInt(4));
                mediaList.add(med);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return mediaList;
    }

}
