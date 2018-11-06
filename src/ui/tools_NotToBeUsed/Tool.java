package ui.tools_NotToBeUsed;

import javax.swing.*;

public abstract class Tool {


    protected JButton button;
    protected Main editor;
    private boolean active;


    protected Tool(Main editor, JComponent parent) {
        this.editor = editor;
        createButton(parent);
        addToParent(parent);
        active = false;
        addListener();
    }

    protected abstract void createButton(JComponent parent);


    public void addToParent(JComponent parent) {
        parent.add(button);
    }


    protected abstract void addListener();


    // EFFECTS: sets this Tool's active field to true
    public void activate() {
        active = true;
    }

    // EFFECTS: sets this Tool's active field to false
    public void deactivate() {
        active = false;
    }



}
