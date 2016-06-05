package com.repositories.artifacts;

import com.businesslogic.artifacts.Plan;
import com.repositories.Repository;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pitochka on 05.06.16.
 */
public class PlanRepository implements Repository<Plan> {
    private static List<Plan> PlanList;

    public PlanRepository() throws SQLException, IOException{
        PlanList = new ArrayList<Plan>();
        PlanList.add(new Plan(12, "test plan", false));
    }

    public PlanRepository(DataSource dataSource) {
        PlanList = new ArrayList<Plan>();
    }

    public List<Plan> getAll() {
        return this.PlanList;
    }

    public Plan get(Plan m_plan) {
        List<Plan> m_list = PlanList.stream()
                .filter(entry -> entry.getId() == m_plan.getId())
                .collect(Collectors.toList());
        return m_list.get(0);
    }

    public void create(Plan m_plan) {
        PlanList.add(m_plan);
    }

    public void update(Plan m_plan) {
        PlanList.stream()
                .filter(entry -> entry.getId() == m_plan.getId())
                .forEach(entry ->
                        entry.setStatus(m_plan.isValidated()));
    }

    public void delete(Plan m_mark) {
        PlanList.removeIf(entry -> entry.getId() == m_mark.getId());
    }

    public void disconnect() {
    }
}
