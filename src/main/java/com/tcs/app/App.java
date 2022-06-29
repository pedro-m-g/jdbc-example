package com.tcs.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        try {
            Connection connection = DataSource.connect();
            BlogDAO blogDAO = new BlogDAO(connection);

            /*
             * Blog firstPost = new Blog("Hello World");
             * blogDAO.publishPost(firstPost);
             */

            List<Blog> blogPosts = blogDAO.listBlogPosts();

            System.out.println(blogPosts);
        } catch (SQLException ex) {
            System.err.println("Could not start program. Please try later.");
        }
    }

}
