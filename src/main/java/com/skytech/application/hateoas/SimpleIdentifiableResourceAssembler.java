package com.skytech.application.hateoas;

import org.springframework.core.GenericTypeResolver;
import org.springframework.hateoas.*;
import org.springframework.hateoas.core.EvoInflectorRelProvider;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author Greg Turnquist
 */
public class SimpleIdentifiableResourceAssembler<T extends Identifiable<?>> extends SimpleResourceAssembler<T> {

    /**
     * The Spring MVC class for the {@link Identifiable} from which links will be built.
     * Spring MVC类的{@link Identifiable}从哪个链接将被构建。
     */
    private final Class<?> controllerClass;

    /**
     * A {@link RelProvider} to look up names of links as options for resource paths.
     * {@link RelProvider} 查找链接名称作为资源路径的选项。
     */
    private final RelProvider relProvider;

    /**
     * A {@link Class} depicting the {@link Identifiable}'s type.
     * 资源类型
     */
    private final Class<?> resourceType;

    /**
     * Default base path as empty.
     * 默认基本路径
     */
    private String basePath = "";

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    /**
     * Default a assembler based on Spring MVC controller, resource type, and {@link RelProvider}. With this combination
     * of information, resource can be defined.
     *
     * @param controllerClass - Spring MVC controller to base links off of
     * @param relProvider
     * @see #setBasePath(String) to adjust base path to something like "/api"/
     */
    public SimpleIdentifiableResourceAssembler(Class<?> controllerClass, RelProvider relProvider) {

        this.controllerClass = controllerClass;
        this.relProvider = relProvider;

        // Find the "T" type contained in "T extends Identifiable<?>", e.g. SimpleIdentifiableResourceAssembler<User> -> User
        this.resourceType = GenericTypeResolver.resolveTypeArgument(this.getClass(), SimpleIdentifiableResourceAssembler.class);
    }

    /**
     * Alternate constructor that falls back to {@link EvoInflectorRelProvider}.
     *
     * @param controllerClass
     */
    public SimpleIdentifiableResourceAssembler(Class<?> controllerClass) {
        this(controllerClass, new EvoInflectorRelProvider());
    }

    /**
     * Define links to add to every {@link Resource}.
     *
     * @param resource
     */
    @Override
    protected void addLinks(Resource<T> resource) {
        resource.add(getCollectionLinkBuilder().slash(resource.getContent()).withSelfRel());
//        resource.add(getCollectionLinkBuilder().withRel(this.relProvider.getCollectionResourceRelFor(this.resourceType)));
    }

    /**
     * Define links to add to {@link Resources} collection.
     *
     * @param resources
     */
    @Override
    protected void addLinks(Resources<Resource<T>> resources) {
        resources.add(getCollectionLinkBuilder().withSelfRel());
    }

    /**
     * 使用Spring MVC控制器构建一个集合的URI，然后转换资源类型。
     * by the {@link RelProvider}.
     */
    protected LinkBuilder getCollectionLinkBuilder() {

        ControllerLinkBuilder linkBuilder = linkTo(this.controllerClass);

        for (String pathComponent : (getPrefix() + this.relProvider.getCollectionResourceRelFor(this.resourceType)).split("/")) {
            if (!pathComponent.isEmpty()) {
                linkBuilder = linkBuilder.slash(pathComponent);
            }
        }

        return linkBuilder;
    }

    private String getPrefix() {
        return getBasePath().isEmpty() ? "" : getBasePath() + "/";
    }
}
