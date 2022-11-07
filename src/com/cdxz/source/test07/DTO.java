package com.cdxz.source.test07;

public class DTO implements Comparable<DTO> {
    private Integer id;
    public DTO(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(DTO o) {
        // 默认从小到大排序
        return id - o.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DTO{" +
                "id=" + id +
                '}';
    }
}
