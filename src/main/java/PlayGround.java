import dao.ManagerDao;
import dao.ReimburseDao;
import model.Manager;
import model.Reimburse;
import services.ReimburseServices;

import java.util.ArrayList;
import java.util.List;

public class PlayGround {
    private static final ReimburseDao reimbDao = new ReimburseDao();
    private static final ManagerDao managerDao = new ManagerDao();
    private static final ReimburseServices reimbServices = new ReimburseServices();

    public static void main(String []args){
        Manager m = managerDao.getManagerById(2);
        List<Reimburse> lor = new ArrayList<>();
        List<Reimburse> lor1 = reimbServices.getReimburseForManager(m);
        List<Reimburse> lor2 = reimbServices.getReimburseForReward(m);
        lor.addAll(lor1);
        lor.addAll(lor2);
        System.out.println(lor);
    }
}
