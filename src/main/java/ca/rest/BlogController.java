package ca.rest;

/**
 * ******************************************** **
 * BlogController - main.BlogController
 *
 * @author Christian Garrovillo
 * Information and Communications Technologies
 * Software Development
 * * ********************************************* **
 */
import ca.rest.dao.BlogRepository;
import ca.rest.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class BlogController {

    @Autowired
    BlogRepository data;

    @GetMapping("/blog")
    public List<Blog> index() {
        return data.findAll();
    }

    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id) {
        return data.findOne(Integer.parseInt(id));
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String title = body.get("title");
        String content = body.get("content");
        return data.findByTitleContainingOrContentContaining(title, content);
    }

//    @PostMapping("/blog")
//    public Blog create(@RequestBody Map<String, String> body) {
//        int id = Integer.parseInt(body.get("id"));
//        String title = body.get("title");
//        String content = body.get("content");
//        return data.save(new Blog(id, title, content));
//    }
    @PostMapping("/blog")
    public Blog create(@RequestBody Blog newBlog) {
        return data.save(newBlog);
    }

//    @PostMapping("/blog/{id}")
//    public Blog update(@RequestBody(required = false) Map<String, String> body, @PathVariable(required = true) String id) {
//        int blogId = Integer.parseInt(id);
//        Blog old = data.findOne(blogId);
//        String title = body.get("title");
//        String content = body.get("content");
//        old.setTitle(title);
//        old.setContent(content);
//        return data.save(old);
//    }
    @PostMapping("/blog/{id}")
    public Blog update(@RequestBody Blog updatedBlog, @PathVariable int id) {
        return data.findOne(id)
    }

    @DeleteMapping("/blog/{id}")
    public List<Blog> delete(@PathVariable String id) {
        data.delete(Integer.parseInt(id));
        return data.findAll();
    }

}
