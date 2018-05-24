package com.skytech.application.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lianhong_ on 2018/05/23 21:31
 */
public class ResourceSupport {

    private final List<Link> links = new ArrayList<>();

    public void add(Link link) {
        Assert.notNull(link, "Link must not be null!");
        this.links.add(link);
    }
}
