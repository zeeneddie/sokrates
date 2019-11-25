package nl.obren.sokrates.sourcecode.aspects;

import java.util.ArrayList;
import java.util.List;

public class DependenciesFinder {
    private boolean useBuiltInDependencyFinders = true;
    private List<DependencyFinderPattern> rules = new ArrayList<>();
    private List<DependencyFinderMetaPattern> metaRules = new ArrayList<>();

    public boolean isUseBuiltInDependencyFinders() {
        return useBuiltInDependencyFinders;
    }

    public void setUseBuiltInDependencyFinders(boolean useBuiltInDependencyFinders) {
        this.useBuiltInDependencyFinders = useBuiltInDependencyFinders;
    }

    public List<DependencyFinderPattern> getRules() {
        return rules;
    }

    public void setRules(List<DependencyFinderPattern> rules) {
        this.rules = rules;
    }

    public List<DependencyFinderMetaPattern> getMetaRules() {
        return metaRules;
    }

    public void setMetaRules(List<DependencyFinderMetaPattern> metaRules) {
        this.metaRules = metaRules;
    }
}