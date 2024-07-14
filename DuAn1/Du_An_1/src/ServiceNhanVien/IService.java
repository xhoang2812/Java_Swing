/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceNhanVien;

import java.util.List;
import Model.NhanVien;

/**
 *
 * @author Admin
 */
public interface IService<T, K> {
    public List<NhanVien> findAll();
    public Integer add(T o);
    public Integer update(T o);
    public Integer delete(K id);
}
