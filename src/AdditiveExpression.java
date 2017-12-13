import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * Child of expression that represents an addition operator.
 */
public class AdditiveExpression extends CollapsibleExpression implements Focusable{

    private boolean focused;
	private Node node;

	/**
	 * Will return a copy of the Additive expression to use
	 * for the GUI.
	 * @return a copy of the {@link AdditiveExpression}
	 */
	public Expression deepCopy() {
		AdditiveExpression copy = new AdditiveExpression();
		copy.node = node;

		return super.deepCopy(copy);
	}

	public Node getNode() {
		if(node == null) {
			final HBox hbox = new HBox();
			hbox.getChildren().add(this.getChildren().get(0).getNode());
			for (int i = 1; i < this.getChildren().size(); i++) {
				hbox.getChildren().add(ExpressionEditor.newLabel("+"));
				hbox.getChildren().add(this.getChildren().get(i).getNode());
			}
			if (this.getFocused()) {
				hbox.setBorder(RED_BORDER);
			}
			node = hbox;
			return hbox;
		}

		return node;
	}

	/**
	 * Will generate a String representation for the the addition
	 * operator, with the appropiate number of tabs to properly
	 * represent it's position in the expression.
	 * @param indentLevel how many "levels" down the operator is
	 * @return a String representing the addition operator.
	 */
	public String convertToString(int indentLevel){
		return super.convertToString(indentLevel,"+");
	}

    @Override
    public boolean getFocused() {
        return this.focused;
    }

    @Override
    public void setFocused(boolean s) {
        this.focused = s;
    }
}