package site.asem.model.relevance.predicates;

import org.jetbrains.annotations.NotNull;
import site.asem.model.entity.Publication;

import java.util.Objects;
import java.util.function.Predicate;

public class TagMatch implements Predicate<Publication> {
    @NotNull
    private String lookingTag;

    public TagMatch(@NotNull String lookingTag) {
        Objects.requireNonNull(lookingTag);
        this.lookingTag = lookingTag;
    }

    @Override
    public boolean test(@NotNull Publication publication) {
        var tags = publication.getTags();
        // TODO optional?
        if (tags == null) {
            return false;
        }
        // TODO stream
        for (String tag : tags) {
            if (tag != null && tag.equalsIgnoreCase(lookingTag)) {
                return true;
            }
        }
        return false;
    }
}
