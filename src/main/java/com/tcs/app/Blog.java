package com.tcs.app;

import java.sql.Date;

public class Blog {

  private int id;
  private String content;
  private Date publishedAt;

  public Blog(int id, String content, Date publishedAt) {
    this.id = id;
    this.content = content;
    this.publishedAt = publishedAt;
  }

  public Blog(String content) {
    this(0, content, new Date(System.currentTimeMillis()));
  }

  public int getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public Date getPublishedAt() {
    return publishedAt;
  }

  @Override
  public String toString() {
    return "Post[" + content + "]";
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Blog)) {
      return false;
    }
    Blog otherBlog = (Blog) other;
    if (id == 0) {
      return content.equals(otherBlog.getContent());
    }
    return id == otherBlog.getId();
  }

}
