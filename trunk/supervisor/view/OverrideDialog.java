/**
  * This file is part of VoteBox.
  * 
  * VoteBox is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * 
  * VoteBox is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * 
  * You should have received a copy of the GNU General Public License
  * along with VoteBox.  If not, see <http://www.gnu.org/licenses/>.
 */
package supervisor.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import supervisor.model.Model;

/**
 * A dialog that is shown when the poll worker attempts to override an
 * authorization. The dialog asks if the user wants to cancel the ballot, cast
 * the ballot, or not override anything.
 * @author cshaw
 */
@SuppressWarnings("serial")
public class OverrideDialog extends JDialog {

    /**
     * Constructs a new OverrideDialog.
     * @param parent the parent
     * @param model the model
     * @param node the serial number of the machine to override
     * @param label the label of the machine to override
     */
    public OverrideDialog(final JPanel parent, final Model model,
            final int node, int label) {
        super((JFrame) null, "Override", true);
        setSize(500, 150);
        setLocationRelativeTo(parent);
        setLayout(new GridBagLayout());
        setAlwaysOnTop(true);
        GridBagConstraints c = new GridBagConstraints();

        JLabel lbl1 = new MyJLabel("You are attempting to override booth #"
                + label + ".");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(10, 10, 0, 10);
        c.gridwidth = 3;
        add(lbl1, c);

        JLabel lbl2 = new MyJLabel(
                "Please designate whether you would like to cancel, or cast, this ballot.");
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 10, 0, 10);
        add(lbl2, c);

        JButton cancelButton = new MyJButton("Cancel Ballot");
        cancelButton.setFont(cancelButton.getFont().deriveFont(Font.BOLD));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                model.overrideCancel(node);
                JOptionPane
                        .showMessageDialog(
                                parent,
                                "Message sent.  You must now go to that booth to complete this action.",
                                "Message Sent", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        c.gridy = 2;
        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 0;
        c.ipady = 20;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        add(cancelButton, c);

        JButton castButton = new MyJButton("Cast Ballot");
        castButton.setFont(castButton.getFont().deriveFont(Font.BOLD));
        castButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                model.overrideCast(node);
                JOptionPane
                        .showMessageDialog(
                                parent,
                                "Message sent.  You must now go to that booth to complete this action.",
                                "Message Sent", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        c.gridx = 1;
        c.insets = new Insets(10, 0, 10, 10);
        add(castButton, c);

        JButton doNothingButton = new MyJButton("Do Not Override");
        doNothingButton
                .setFont(doNothingButton.getFont().deriveFont(Font.BOLD));
        doNothingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        c.gridx = 2;
        add(doNothingButton, c);
    }
}
