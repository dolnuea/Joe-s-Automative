import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


/**
 * @author Dolunay Dagci
 * 2.24.18
 * Fixed Code: 6.3.19
 * Assignment: Ch12 Joe's Automotive
 * CISS111-360
 * This program does following maintanence services:
 *
 * -Oil change $26.00
 * -Lube Job 18.00
 * Radiator Flush 30.00
 * Transmission Flush 80.00
 * Inspection 15.00
 * Muffler Replacement 100.00
 * Tire Rotation 20.00
 * Other non-routine services -for parts and labor - 20/hour
 * display total for a customer's visit to Joe's
 */

public class DD_JoeAutomotive extends JFrame {

    //private fields
    private  JPanel jPanel, routinePanel, non_routinePanel;
    private JTextField hoursField, partsField;
    private JCheckBox oilChange;
    private JCheckBox lubeJob;
    private JCheckBox radiatorFlush;
    private JCheckBox transmissionFlush;
    private JCheckBox inspection;
    private JCheckBox mufflerReplace;
    private JCheckBox tireRotation;
    private JCheckBox otherServices;
    private JButton totalButton;
    private DecimalFormat df = new DecimalFormat("#0.00");

    public DD_JoeAutomotive() {

        setTitle("Joe's Automotive Services");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        jPanel = new JPanel();
        routinePanel = new JPanel();
        non_routinePanel = new JPanel();

        oilChange = new JCheckBox("Oil Change($26.00)");
        lubeJob	= new JCheckBox("Lube job($18.00)");
        radiatorFlush = new JCheckBox("Radiator flush($30.00)");
        transmissionFlush = new JCheckBox("Transmission flush($80.00)");
        inspection = new JCheckBox("Inspection($15.00)");
        mufflerReplace = new JCheckBox("Muffler replacement($100.00)");
        tireRotation = new JCheckBox("Tire rotation($20.00)");

        otherServices = new JCheckBox("Non-routine services:");
        hoursField = new JTextField(3);
        hoursField.setToolTipText("Enter Hours For Labor");
        partsField = new JTextField( 3);
        partsField.setToolTipText("Enter Cost Of Parts");

        totalButton = new JButton("Total");

        totalButton.addActionListener(new TotalListener()); //add Action listener

        //add components
        routinePanel.add(oilChange);
        routinePanel.add(lubeJob);
        routinePanel.add(radiatorFlush);
        routinePanel.add(transmissionFlush);

        routinePanel.add(inspection);
        routinePanel.add(mufflerReplace);
        routinePanel.add(tireRotation);

        non_routinePanel.add(otherServices);
        non_routinePanel.add(hoursField);
        non_routinePanel.add(partsField);
        jPanel.add(totalButton);

        routinePanel.setBorder(BorderFactory.createTitledBorder("Routine Services"));

        non_routinePanel.setBorder(BorderFactory.createTitledBorder("Non-Routine Services"));
        routinePanel.setBackground(Color.LIGHT_GRAY);
        non_routinePanel.setBackground(Color.LIGHT_GRAY);
        jPanel.setBackground(Color.GRAY);

        add(jPanel, BorderLayout.SOUTH);
        add(routinePanel, BorderLayout.NORTH);
        add(non_routinePanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    private class TotalListener implements ActionListener { //create an Action Listener class for total button

        double non_routine_serviceCost;
        double total = 0;
        String hourInput;
        String partsInput;

        @Override
        public void actionPerformed(ActionEvent e) {
            total = 0; //clear total

            //adds prices of all checkboxes selected
            if ( oilChange.isSelected()) {
                total += 26;}
            if ( lubeJob.isSelected()){
                total += 18;}
            if ( radiatorFlush.isSelected()){
                total += 30;}
            if ( transmissionFlush.isSelected()){
                total += 80;}
            if ( inspection.isSelected()){
                total += 15;}
            if ( mufflerReplace.isSelected()){
                total += 100;}
            if ( tireRotation.isSelected()){
                total += 20;}
            if ( otherServices.isSelected())
            {
                try {
                    hourInput = hoursField.getText();
                    partsInput = partsField.getText();
                    non_routine_serviceCost = (Double.parseDouble(hourInput) * 20) + (Double.parseDouble(partsInput)); //it charges $20 each hour so parseDouble input and multiply it by 20
                    total += non_routine_serviceCost; //add it to the total
                    hoursField.setText(""); partsField.setText(""); //clear text fields after total is clicked
                } catch (RuntimeException a)  { //catch any exceptions for empty text fields
                    JOptionPane.showMessageDialog(null, "Please fill in the text fields." ,
                            "Empty Text Fields", JOptionPane.ERROR_MESSAGE);
                }
            }
            //clear everything after total is clicked
            oilChange.setSelected(false); lubeJob.setSelected(false);
            radiatorFlush.setSelected(false); transmissionFlush.setSelected(false);
            transmissionFlush.setSelected(false); inspection.setSelected(false);
            mufflerReplace.setSelected(false); tireRotation.setSelected(false);
            otherServices.setSelected(false);

            JOptionPane.showMessageDialog(null, "Total: $" + df.format(total), "Total", JOptionPane.INFORMATION_MESSAGE); //displays the total

        }

    }
    public static void main(String[] args){
        new DD_JoeAutomotive();
    }


}


