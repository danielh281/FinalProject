package org.dh;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import util.Util;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    /**
     * Checks whether a department name is valid or not.
     * If the department name contains characters other than
     * letters or spaces, it is considered invalid.
     * @param departmentName The department name to check
     * @return True if the department name is valid. False if the department name is invalid
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null) {
            return false;
        }

        char[] chars = departmentName.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c) && !(c == ' ')) {
                return false;
            }
        }

        return true;
    }

    public Department(String departmentName) {
        this.departmentId = String.format("D%02d", nextId++);
        this.departmentName = (isDepartmentNameValid(departmentName)) ? Util.toTitleCase(departmentName) : null;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = (isDepartmentNameValid(departmentName)) ? departmentName : this.departmentName;
    }
}
