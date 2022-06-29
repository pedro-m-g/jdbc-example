package com.tcs.app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO {

  private Connection connection;

  public BlogDAO(Connection connection) {
    this.connection = connection;
  }

  public List<Blog> listBlogPosts() throws SQLException {
    String query = "SELECT * FROM blog";
    try (Statement statement = connection.createStatement()) {
      List<Blog> blogPosts = new ArrayList<>();
      ResultSet rs = statement.executeQuery(query);
      while (rs.next()) {
        int id = rs.getInt("id");
        String content = rs.getString("content");
        Date publishedAt = rs.getDate("published_at");

        Blog blog = new Blog(id, content, publishedAt);
        blogPosts.add(blog);
      }
      return blogPosts;
    }
  }

  public void publishPost(Blog blog) throws SQLException {
    String query = "INSERT INTO blog (content, published_at) VALUES (?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, blog.getContent());
      statement.setDate(2, blog.getPublishedAt());

      statement.executeUpdate();
    }
  }

}
