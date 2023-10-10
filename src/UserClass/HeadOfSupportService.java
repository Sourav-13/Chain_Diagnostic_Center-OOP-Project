package UserClass;

import SupportingUsers.SecurityGuard;
import NonUserClass.AppendableObjectOutputStream;
import NonUserClass.EquipentRequestApplication;
import NonUserClass.SuggestionAndComplain;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class HeadOfSupportService extends Employee implements Serializable {

    private ArrayList<EquipentRequestApplication> equipReqAppList;

    //private SuggestionAndComplain sc;
    public HeadOfSupportService() {
    }

    public HeadOfSupportService(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob) {
        super(phnNo, name, gender, branchName, desig, dob);

    }

    public HeadOfSupportService(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob, float salary, String password, int id) {
        super(phnNo, name, gender, branchName, desig, dob, salary, password, id);
    }

    public static HeadOfSupportService addInstance(String name, int phone, String gender, String branch, LocalDate doB) {

        HeadOfSupportService hss = null;
        int temp = 0;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            // File f = new File("Employee.bin");

            File f = new File("HeadOfSupportService.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Employee emp;
            try {

                while (true) {

                    emp = (HeadOfSupportService) ois.readObject();
                    temp = emp.getId();

                }
            }//end of nested try
            catch (Exception e) {
                //
            }//nested catch     

        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        try {

            File f = new File("HeadOfSupportService.bin");
            //File f = new File("Employee.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                hss = new HeadOfSupportService(phone, name, gender, branch, "Head Of Support", doB, 50000, "123", temp + 1);
                oos.writeObject(hss);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                hss = new HeadOfSupportService(phone, name, gender, branch, "Head Of Support", doB, 50000, "123", (branch.equals("Uttara") ? 12000 : 22000));

                oos.writeObject(hss);
            }

        } catch (IOException ex) {

        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
            }
        }
        return hss;
    }

    public void provideFoodService() {
    }

    public void provideCleanAndLaundryService() {
    }

    public boolean provideAmbulanceService() {
        return true;
    }

    public boolean requestEquipment( int reqId, int empid, LocalDate sub, String title, String des, String branch) 
    {
        EquipentRequestApplication equipReq;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        int temp = 0;

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("EquipmentRequestApplication.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    equipReq = (EquipentRequestApplication) ois.readObject();
                    temp = equipReq.getEquipReqId();
                }
            }//end of nested try
            catch (Exception e) {
                //
            }//nested catch     

        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        try {
            File f = new File("EquipmentRequestApplication.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                equipReq = new EquipentRequestApplication( reqId, empid,  sub,  title,  des, branch );


                //equipReq = new EquipentRequestApplication( int reqId, int empid, LocalDate sub, String title, String des, String branch);
                oos.writeObject(equipReq);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                equipReq = new EquipentRequestApplication( reqId, empid,  sub,  title,  des, branch);
                oos.writeObject(equipReq);
            }

        } catch (IOException ex) {

        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
            }
        }
        return true;
        
    }

    public void getBlood() {
    }

    public void deliverMedicalSupplies() {
    }

    public void changeShiftsOfSecurityguards() {
    }

    public ObservableList<SuggestionAndComplain> monitorSuggestionAndComplain() {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ObservableList<SuggestionAndComplain> sac = FXCollections.observableArrayList();

        try {
            f = new File("SuggestionsAndComplains.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    //  equip = (ObservableList) ((EquipentRequestApplication) ois.readObject());
                    sac.add((SuggestionAndComplain) ois.readObject());
                }

            } catch (Exception e) {
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        return sac;
         
    }

    public ObservableList<SecurityGuard> securityGuardDetails() {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ObservableList<SecurityGuard> sg = FXCollections.observableArrayList();

        try {
            f = new File("SecurityGuard.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    //  equip = (ObservableList) ((EquipentRequestApplication) ois.readObject());
                    sg.add((SecurityGuard) ois.readObject());
                }

            } catch (Exception e) {
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        return sg;
    }

}
