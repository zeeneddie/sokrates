package nl.obren.sokrates.sourcecode.aspects;

import java.util.ArrayList;
import java.util.List;

public class CrossCuttingConcernsGroup {
    private String name = "";
    private List<CrossCuttingConcern> concerns = new ArrayList<>();
    private List<MetaRule> metaConcerns = new ArrayList<>();

    public CrossCuttingConcernsGroup() {
    }

    public CrossCuttingConcernsGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CrossCuttingConcern> getConcerns() {
        return concerns;
    }

    public void setConcerns(List<CrossCuttingConcern> concerns) {
        this.concerns = concerns;
    }

    public List<MetaRule> getMetaConcerns() {
        return metaConcerns;
    }

    public void setMetaConcerns(List<MetaRule> metaConcerns) {
        this.metaConcerns = metaConcerns;
    }
}
