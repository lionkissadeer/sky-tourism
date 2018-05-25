package com.skytech.application.hateoas;

import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;

/**
 * 类似 {@link ResourceAssembler} 但这里是用于集合资源.
 *
 * @author Greg Turnquist
 */
public interface ResourcesAssembler<T, D extends ResourceSupport> {

    /**
     * 将所有给定的实体转换为资源，并将集合包装为资源。
     */
    Resources<D> toResources(Iterable<? extends T> entities);

}
