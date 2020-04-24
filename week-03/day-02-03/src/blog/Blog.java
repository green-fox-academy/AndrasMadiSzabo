package blog;

import blogpost.BlogPost;
import java.util.ArrayList;
import java.util.List;

public class Blog {
  protected List<BlogPost> blog;

  public Blog() {
    this.blog = new ArrayList<>();
  }
  public void addBlogpost(BlogPost blogPost){
    this.blog.add(blogPost);
  }
  public void deleteBlogpost(int index){
    this.blog.remove(index);
  }

  public void updateBlogpost(int index, BlogPost blogPost){
    this.blog.add(index, blogPost);
  }

  public void printBlogpost(int index){
    System.out.println(this.blog.get(index).getAuthorName());
    System.out.println(this.blog.get(index).getTitle());
    System.out.println(this.blog.get(index).getText());
  }

  public List<BlogPost> getBlog() {
    return blog;
  }

//  @Override
//  public String toString() {
//    return "Blog{" +
//        "blog=" + blog +
//        '}';
//  }
}


//  Create a Blog class which can store a list of BlogPosts
//    add BlogPosts to the list
//    delete(int) one item at given index
//    update(int, BlogPost) one item at the given index and update it with another BlogPost