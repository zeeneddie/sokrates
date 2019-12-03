package nl.obren.sokrates.reports.core;

import nl.obren.sokrates.common.analysis.Finding;
import nl.obren.sokrates.common.renderingutils.RichTextRenderingUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RichTextReport {
    private List<RichTextFragment> richTextFragments = new ArrayList<>();
    private String id;
    private String fileName = "";
    private String displayName;
    private String group = "";
    private String description = "";
    private String logoLink = "";
    private List<Finding> findings = new ArrayList<>();

    public RichTextReport() {
    }

    public RichTextReport(String id, String fileName) {
        this.id = id;
        this.displayName = id;
        this.fileName = fileName;
    }

    public RichTextReport(String id, String description, String logoLink) {
        this.id = id;
        this.displayName = id;
        this.description = description;
        this.logoLink = logoLink;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        if (StringUtils.isBlank(fileName)) {
            return id.replace("-", "").replace(" ", "") + ".html";
        } else {
            return fileName;
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RichTextFragment> getRichTextFragments() {
        return richTextFragments;
    }

    public void setRichTextFragments(List<RichTextFragment> richTextFragments) {
        this.richTextFragments = richTextFragments;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public void setLogoLink(String logoLink) {
        this.logoLink = logoLink;
    }

    public void addLevel1Header(String text) {
        addHtmlContent("<h1>" + text + "</h1>\n");
    }

    public void addLevel2Header(String text) {
        addHtmlContent("<h2>" + text + "</h2>\n");
    }

    public void addLevel2Header(String text, String style) {
        addHtmlContent("<h2 style=\"" + style + "\">" + text + "</h2>\n");
    }

    public void addLevel3Header(String text) {
        addHtmlContent("<h3>" + text + "</h3>\n");
    }

    public void addLevel3Header(String text, String style) {
        addHtmlContent("<h3 style=\"" + style + "\">" + text + "</h2>\n");
    }

    public void addLevel4Header(String text) {
        addHtmlContent("<h4>" + text + "</h4>\n");
    }

    public void addParagraph(String text) {
        addHtmlContent("<p>" + text + "</p>\n");
    }

    public void addEmphasisedParagraph(String text) {
        addHtmlContent("<p><i>\"" + text + "\"</i></p>\n");
    }

    public void addQuoteParagraph(String quote, String source) {
        addHtmlContent("<p><i>\"" + quote + "\"</i> (" + source + ")</p>\n");
    }

    public void addEmphasisedText(String text) {
        addHtmlContent("<i>" + text + "</i>");
    }

    public void addStrongText(String text) {
        addHtmlContent("<b>" + text + "</b>");
    }

    public void addSvgFigure(String title, String svg) {
        RichTextFragment richTextFragment = new RichTextFragment(svg, RichTextFragment.Type.SVG);
        richTextFragment.setDescription(title);
        richTextFragments.add(richTextFragment);
    }

    public List<Finding> getFindings() {
        return findings;
    }

    public void addHtmlContent(String html) {
        richTextFragments.add(new RichTextFragment(html, RichTextFragment.Type.HTML));
    }

    public void addGraphvizFigure(String description, String graphvizCode) {
        this.startDiv("width: 100%; overflow: auto");
        RichTextFragment fragment = new RichTextFragment(graphvizCode, RichTextFragment.Type.GRAPHVIZ);
        fragment.setDescription(description);
        richTextFragments.add(fragment);
        this.endDiv();
    }

    public void addTableHeader(String... columns) {
        for (String column : columns) {
            addHtmlContent("<th>" + column + "</th>\n");
        }
    }

    public void startTable() {
        addHtmlContent("<table>\n");
    }

    public void startTable(String style) {
        addHtmlContent("<table style=\"" + style + "\">\n");
    }

    public void endTable() {
        addHtmlContent("</table>\n");
    }

    public void addTableCell(String text) {
        addHtmlContent("<td>" + text + "</td>\n");
    }

    public void startTableCell() {
        addHtmlContent("<td>");
    }

    public void startTableCell(String style) {
        addHtmlContent("<td style=\"" + style + "\">");
    }

    public void endTableCell() {
        addHtmlContent("</td>\n");
    }

    public void startTableRow() {
        addHtmlContent("<tr>\n");
    }

    public void endTableRow() {
        addHtmlContent("</tr>\n");
    }

    public void addListItem(String text) {
        addHtmlContent("<li>" + text + "</li>\n");
    }

    public void startUnorderedList() {
        addHtmlContent("<ul>\n");
    }

    public void startUnorderedList(String style) {
        addHtmlContent("<ul style='" + style + "'>\n");
    }

    public void endUnorderedList() {
        addHtmlContent("</ul>\n");
    }

    public void addLineBreak() {
        addHtmlContent("<br/>\n");
    }

    public void addHorizontalLine() {
        addHtmlContent("<hr/>\n");
    }

    public void addAnchor(String anchor) {
        addHtmlContent("<a name=\"" + anchor + "\"></a>");
    }

    public void startDiv(String style) {
        addHtmlContent("<div style=\"" + style + "\">");
    }

    public void addContentInDiv(String content) {
        addContentInDiv(content, "");
    }

    public void addContentInDiv(String content, String style) {
        startDiv(style);
        addHtmlContent(content);
        endDiv();
    }

    public void startSection(String title, String subtitle) {
        this.addHtmlContent("<div class='section'>" +
                "<div class='sectionHeader'>\n" +
                "    <span class='sectionTitle'>" + title + "</span>\n" +
                (StringUtils.isNotBlank(subtitle) ? "    <div class='sectionSubtitle'>" + subtitle + "</div>\n" : "") +
                "</div>\n" +
                "<div class='sectionBody'>");
    }

    public void startSubSection(String title, String subtitle) {
        this.addHtmlContent("<div class='subSection'>" +
                "<div class='subSectionHeader'>\n" +
                "    <span class='subSectionTitle'>" + title + "</span>\n" +
                (StringUtils.isNotBlank(subtitle) ? "    <div class='subSectionSubtitle'>" + subtitle + "</div>\n" : "") +
                "</div>\n" +
                "<div class='sectionBody'>");
    }

    public void endDiv() {
        addHtmlContent("</div>");
    }

    public void endSection() {
        addHtmlContent("</div>\n" +
                "</div>");
    }

    public void addParagraph(String text, String style) {
        addHtmlContent("<p style=\"" + style + "\">" + text + "</p>\n");
    }

    public void addTableCell(String text, String style) {
        addHtmlContent("<td style=\"" + style + "\">" + text + "</td>");

    }

    public void addShowMoreBlock(String visibleContent, String hiddenContent, String linkLabel) {
        addHtmlContent(RichTextRenderingUtils.getShowMoreParagraph(visibleContent, hiddenContent, linkLabel));
    }

    public void startShowMoreBlock(String visibleContent, String linkLabel) {
        addHtmlContent(RichTextRenderingUtils.getStartShowMoreParagraph(visibleContent, linkLabel));
    }

    public void endShowMoreBlock() {
        addHtmlContent(RichTextRenderingUtils.getEndShowMoreParagraph());
    }
}
