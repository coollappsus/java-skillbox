import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JLabel labelLastName;
    private JTextArea textAreaLastName;
    private JLabel labelFirstName;
    private JTextArea textAreaFirstName;
    private JLabel labelMiddleName;
    private JTextArea textAreaMiddleName;
    private JButton button;
    private JLabel labelFullName;
    private JTextArea textAreaFullName;
    private JPanel jPanelLastName;
    private JPanel jPanelFirstName;
    private JPanel jPanelMiddleName;
    private JPanel jPanelFullName;

    public MainForm() {
        button.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jPanelFirstName.isVisible()) {
                    collapse();
                } else {
                    expand();
                }
            }
        });
    }

    public void collapse() {
        String firstName = textAreaFirstName.getText().trim();
        String lastName = textAreaLastName.getText().trim();
        String middleName = textAreaMiddleName.getText().trim();
        if (firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "The First name or Last name fields is empty",
                    "Field is empty",
                    JOptionPane.PLAIN_MESSAGE
            );
            return;
        }
        setVisibleJpanel(false);
        textAreaFullName.setText(lastName + "\s" + firstName + "\s" + middleName);
    }

    public void expand() {
        String[] fullName = textAreaFullName.getText().trim().split(" ");
        if (fullName.length == 2 || fullName.length == 3) {
            textAreaLastName.setText(fullName[0]);
            textAreaFirstName.setText(fullName[1]);
            if (fullName.length == 3) {
                textAreaMiddleName.setText(fullName[2]);
            } else {
                textAreaMiddleName.setText("");
            }
            setVisibleJpanel(true);
        }
    }

    public void setVisibleJpanel(boolean flag) {
        jPanelFirstName.setVisible(flag);
        jPanelLastName.setVisible(flag);
        jPanelMiddleName.setVisible(flag);
        jPanelFullName.setVisible(!flag);
        button.setText(flag? "Collapse" : "Expand");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
