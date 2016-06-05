package com.repositories.artifacts;

import com.businesslogic.artifacts.Plan;
import com.mappers.artifacts.PlanMapper;
import com.mappers.database.DataSourceGateway;
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
    private static PlanMapper m_planMapper;

    public PlanRepository() throws SQLException, IOException {
        PlanList = new ArrayList<Plan>();
        DataSourceGateway gateway = DataSourceGateway.getInstance();
        m_planMapper = new PlanMapper(DataSourceGateway.getDataSource());
        PlanList.add(new Plan(12, "test plan", false));
    }

    public PlanRepository(DataSource dataSource) throws SQLException {
        PlanList = new ArrayList<Plan>();
        m_planMapper = new PlanMapper(dataSource);
    }

    public List<Plan> getAll() {
        return this.PlanList;
    }

    public Plan get(Plan m_plan) throws SQLException{
        List<Plan> m_list = PlanList.stream()
                .filter(entry -> entry.getId() == m_plan.getId())
                .collect(Collectors.toList());
        if (m_list.isEmpty()) {
            Plan plan = m_planMapper.find(m_plan.getId());
            m_list.add(plan);
            return plan;
        }
        return m_list.get(0);
    }

    public void create(Plan m_plan) throws SQLException {
        PlanList.add(m_plan);
        m_planMapper.insert(m_plan);
    }

    public void update(Plan m_plan) throws SQLException{
        PlanList.stream()
                .filter(entry -> entry.getId() == m_plan.getId())
                .forEach(entry ->
                        entry.setStatus(m_plan.isValidated()));
        m_planMapper.update(m_plan);
    }

    public void delete(Plan m_mark) throws SQLException {
        PlanList.removeIf(entry -> entry.getId() == m_mark.getId());
        m_planMapper.delete(m_mark);
    }

    public void disconnect() throws SQLException {
        m_planMapper.closeConnection();
    }
}
