package aquariumproject;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class View extends javax.swing.JFrame {

    DefaultListModel<String> listModel = new DefaultListModel();
    FileReadWrite data = new FileReadWrite();
    ArrayList<String> fish = data.getFishData();
    ArrayList<Fish> fishes = new ArrayList<>();
    ArrayList<String> userFish = data.getUserFishData();
    
    private void saveUserData(){
        data.writeData(fishes);
    }
    
    private void loadData(ArrayList<String> fishesTemp){
        for (String str : fishesTemp) {
            Fish ActualFish = new Fish(str.split(" ")[0], Integer.parseInt(str.split(" ")[1]), 
                    (String) str.split(" ")[2],
                    Integer.parseInt(str.split(" ")[3]),
                    check(str.split(" ")[4]),
                    Integer.parseInt(str.split(" ")[5]), Integer.parseInt(str.split(" ")[6]),
                    str.split(" ")[7], Integer.parseInt(str.split(" ")[8]), Integer.parseInt(str.split(" ")[9]));
            listModel.addElement(str.split(" ")[0]);
            fishes.add(ActualFish);
        }
    }
    private boolean check(String str){
        if (str.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
    
    private void removeFish(ArrayList<Fish> temporary){
        try {
            String names = fishList.getSelectedValue();
            for (Fish actual : temporary) {
            if (names.equals(actual.getName())) {
                fishes.remove(actual);
                listModel.removeElement(actual.getName());
                name.setText("");
                age.setValue(0);
                fishList.setSelectedIndex(-1);
            }
        }
        } catch (Exception e) {
        }
        
        
    }
    
    private boolean getSex() {
        if (male.isSelected()) {
            return true;
        } else {
            return false;
        }
        
    }
    
    private void showData(ArrayList<Fish> temporary) {
        try {
            String names = fishList.getSelectedValue();
        for (Fish actual : temporary) {
            if (names.equals(actual.getName())) {
                name.setText(actual.getName());
                spec.setSelectedItem(actual.getSpecies());
                temp.setText(actual.getTemp() + "-Celsius");
                minSize.setText(actual.getLenght() + "-liter");
                size.setText(actual.getLenght() + "-cm");
                food.setText(actual.getFood());
                age.setValue(actual.getAge());
                if (actual.isSex()) {
                    male.setSelected(true);
                } else {
                    female.setSelected(true);
                }
                String place = "/pics/";
                place = place.concat(actual.getPicsID() + "");
                place = place.concat(".jpg");
                //System.out.println(place);
                try {
                    picture.setIcon(new javax.swing.ImageIcon(getClass().getResource(place)));
                } catch (Exception e) {
                    System.out.println("Hibás elérési út");
                }
            }
        }
        } catch (Exception e) {
        }
        
    }
    
    private boolean errorCheck() {
        boolean error = false;
        if (name.getText().equals(" ") || (int) age.getValue() <= 0) {
            error = true;
            JOptionPane.showMessageDialog(rootPane, "Hibás érték vagy üres mező!");
        }
        return error;
    }

    private void addFish() {
        if (!errorCheck()) {
            int picsID = 0;
            String actualSpec = (String) spec.getSelectedItem();
            
            for (int i = 0; i < fish.size(); i++) {
                
                if (fish.get(i).split(" ")[0].equals(actualSpec)) {
                    String[] temporary = fish.get(i).split(" ");
                    picsID = Integer.parseInt(temporary[5]);
                }
            }
            
            Fish fish = new Fish(name.getText(), (int) age.getValue(), (String) spec.getSelectedItem(), 100, getSex(), Integer.parseInt(temp.getText().split("-")[0]), Integer.parseInt(size.getText().split("-")[0]), food.getText(), Integer.parseInt(minSize.getText().split("-")[0]), picsID);
            fishes.add(fish);
            listModel.addElement(fish.getName());
        }
        name.setText("");
        age.setValue(0);
        
    }

    private void defaultDataSet() {
        for (int i = 0; i < fish.size(); i++) {
            String[] temp = fish.get(i).split(" ");
            spec.addItem((temp[0]));
        }
    }

    private void changeFish() {
        String actualSpec = (String) spec.getSelectedItem();
        //System.out.println(actualSpec);
        for (int i = 0; i < fish.size(); i++) {
            
            if (fish.get(i).split(" ")[0].equals(actualSpec)) {
                String[] temporary = fish.get(i).split(" ");
                temp.setText(temporary[1]);
                minSize.setText(temporary[2]);
                size.setText(temporary[3]);
                food.setText(temporary[4]);
                String place = "/pics/";
                place = place.concat(temporary[5]);
                place = place.concat(".jpg");
                //System.out.println(place);
                try {
                    picture.setIcon(new javax.swing.ImageIcon(getClass().getResource(place)));
                } catch (Exception e) {
                    System.out.println("Hibás elérési út");
                }
                
            }
        }
    }
    
    public View() {
        initComponents();
        defaultDataSet();
        fishList.setModel(listModel);
        loadData(userFish);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        desktopPane = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        fishList = new javax.swing.JList<>();
        picture = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spec = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        age = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        temp = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        minSize = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        size = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        food = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        gif = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        save = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Akvárium");
        setName("mainFrame"); // NOI18N
        setResizable(false);

        fishList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        fishList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                fishListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(fishList);

        picture.setBackground(new java.awt.Color(255, 255, 255));
        picture.setForeground(new java.awt.Color(255, 255, 255));
        picture.setText("picture");

        jLabel1.setText("Név:");

        jLabel2.setText("Nem:");

        buttonGroup1.add(male);
        male.setSelected(true);
        male.setText("Hím");

        buttonGroup1.add(female);
        female.setText("Nőstény");

        jLabel3.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Halak:");

        jLabel4.setText("Faj:");

        spec.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                specItemStateChanged(evt);
            }
        });

        jLabel5.setText("Kor:");

        jLabel6.setText("Hőigény:");

        jLabel7.setText("Minimum akvárium méret:");

        jLabel8.setText("Testhossz:");

        jLabel9.setText("Étel:");

        add.setText("Hozzáad");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        modify.setText("Módosít");

        delete.setText("Töröl");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        gif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aquariumproject/giphy.gif"))); // NOI18N

        desktopPane.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(picture, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(male, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(female, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(spec, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(age, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(temp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(minSize, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(size, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(food, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(add, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(modify, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(delete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(gif, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(desktopPaneLayout.createSequentialGroup()
                                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(male, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(female, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(add, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(desktopPaneLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(desktopPaneLayout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(food, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(desktopPaneLayout.createSequentialGroup()
                                                    .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(desktopPaneLayout.createSequentialGroup()
                                                            .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(spec, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(32, 32, 32)
                                                            .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jLabel7))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(minSize, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, desktopPaneLayout.createSequentialGroup()
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, desktopPaneLayout.createSequentialGroup()
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(desktopPaneLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(gif)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(desktopPaneLayout.createSequentialGroup()
                                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(male)
                                    .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(female)
                                        .addComponent(jLabel7))
                                    .addComponent(minSize, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(food, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(modify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gif)
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );

        menu1.setText("Fájl");

        save.setText("Mentés");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        menu1.add(save);

        jMenuItem1.setText("Információ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu1.add(jMenuItem1);

        exit.setText("Kilépés");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        menu1.add(exit);

        menuBar.add(menu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(null, "Biztosan kilép?", "Kilépés", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Készítők: \nKészült: 2020 ");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void specItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_specItemStateChanged
        changeFish();
    }//GEN-LAST:event_specItemStateChanged

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        addFish();
    }//GEN-LAST:event_addActionPerformed

    private void fishListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_fishListValueChanged
        showData(fishes);
    }//GEN-LAST:event_fishListValueChanged

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       
            removeFish(fishes);
        
    }//GEN-LAST:event_deleteActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       saveUserData();
    }//GEN-LAST:event_saveActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JSpinner age;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton delete;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exit;
    private javax.swing.JRadioButton female;
    private javax.swing.JList<String> fishList;
    private javax.swing.JLabel food;
    private javax.swing.JLabel gif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton male;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel minSize;
    private javax.swing.JButton modify;
    private javax.swing.JTextField name;
    private javax.swing.JLabel picture;
    private javax.swing.JMenuItem save;
    private javax.swing.JLabel size;
    private javax.swing.JComboBox<String> spec;
    private javax.swing.JLabel temp;
    // End of variables declaration//GEN-END:variables
}
