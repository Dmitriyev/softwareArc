package com.businesslogic.artifacts;

/**
Учебгый план
 */
public class Plan {
    private String m_plan;
    private boolean validated = false;

    public Plan() {

    }

    public Plan(String text) {
        this.m_plan = text;
    }

    public void setText(String text) {
        this.m_plan = text;
    }

    public String getText() {
        return this.m_plan;
    }

    public void validate() {
        this.validated = true;
    }
}
