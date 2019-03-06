package site.asem.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import site.asem.model.entity.Monograph;
import site.asem.model.entity.Publication;
import site.asem.model.entity.WebArticle;
import site.asem.model.relevance.RelevanceFunction;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class Registry {
    private static Registry instance = new Registry();

    static {
        // FIXME move to enum
        Monograph elements = new Monograph("The Elements",
                "248+235+050",
                Arrays.asList("\tEuclid"),
                100500,
                200,
                Arrays.asList("math", "geometry", "number theory"),
                Arrays.asList(),
                "",
                "Self-published",
                1);
        getInstance().addPublication(elements);
        Monograph newton = new Monograph("Mathematical Principles of Natural Philosophy",
                "248+235",
                Arrays.asList("Newton Issac"),
                100500,
                1687,
                Arrays.asList("math", "physics"),
                Arrays.asList(elements),
                "354-645-4313-545",
                "Edmund Halley",
                100500);
        getInstance().addPublication(newton);
        getInstance().addPublication(new WebArticle("Applied cryptography",
                "230",
                Arrays.asList("Diffi", "Hellman"),
                3,
                1990,
                Arrays.asList("cryptography", "math", "secret keys interchange"),
                Arrays.asList(newton),
                "http://www.dh.org"));
    }

    private long nextID = 0;
    private List<Publication> publications = new LinkedList<>();

    private Registry() {
    }

    public static Registry getInstance() {
        return instance;
    }

    @Nullable
    public Publication getByID(long id) {
        List<Publication> a = getPublications(p -> p.getId() == id);
        if (a.size() == 0) {
            return null;
        }
        return a.get(0);
    }

    private List<Publication> getPublications(Predicate<Publication> p) {
        return publications.stream()
                .filter(p).
                        collect(Collectors.toList());
    }

    public void addPublication(@NotNull Publication p) {
        p.setId(nextID++);
        publications.add(p);
    }

    /**
     * Returns <b>ONLY RELEVANT</b> publications(those, when f(publication) > 0)
     * sorted by relevance function descending
     *
     * @param f relevance function
     * @return sorted relevant publications
     */
    public Collection<Publication> getSortedByRelevance(@NotNull RelevanceFunction f) {
        List<Publication> pubs = publications.stream()
                .filter(p -> f.apply(p) > 0)
                .collect(Collectors.toList());
        pubs.sort(Comparator.comparingLong(f::apply).reversed());
        return pubs;
    }


}
