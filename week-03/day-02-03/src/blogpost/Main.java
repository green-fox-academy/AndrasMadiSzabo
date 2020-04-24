package blogpost;

import blog.Blog;

public class Main {
    public static void main(String[] args) {
        BlogPost post1 = new BlogPost("John Doe", "Lorem Ipsum",
            "Lorem ipsum dolor sit amet.", "2000.05.04.");
        BlogPost post2 = new BlogPost("Tim Urban", "Wait but why",
            "A popular long-form, stick-figure-illustrated blog about almost everything.",
            "2010.10.10.");
        BlogPost post3 = new BlogPost("William Turton",
            "One Engineer Is Trying to Get IBM to Reckon With Trump",
            "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. " +
                "When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t " +
                "really into the whole organizer profile thing.", "2017.03.28.");

        System.out.println(post1.title);

        Blog blog = new Blog();
        blog.addBlogpost(post1);
        blog.addBlogpost(post2);
        System.out.println(blog.getBlog().get(0).title);
        blog.printBlogpost(1);
        blog.deleteBlogpost(0);
        blog.updateBlogpost(1, post3);
        blog.printBlogpost(0);
        blog.printBlogpost(1);
    }
}
