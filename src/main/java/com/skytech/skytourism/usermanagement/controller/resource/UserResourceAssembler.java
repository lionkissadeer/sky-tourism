package com.skytech.skytourism.usermanagement.controller.resource;

import com.skytech.application.hateoas.SimpleIdentifiableResourceAssembler;
import com.skytech.skytourism.usermanagement.controller.UserController;
import com.skytech.skytourism.usermanagement.domain.model.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Lianhong_ on 2018/05/24 14:08
 * 用户资源创建
 */
@Component
public class UserResourceAssembler extends SimpleIdentifiableResourceAssembler<User> {

    public UserResourceAssembler() {
        super(UserController.class);
    }

    @Override
    protected void addLinks(Resource<User> resource) {
        //调用 super.ddLink(Resource resource)创建 self-link
        super.addLinks(resource);

        //自定义添加link
        resource.add(linkTo(methodOn(UserController.class)
                .userInfoByName(resource.getContent().getUsername())).withRel("userByName"));
    }
}
