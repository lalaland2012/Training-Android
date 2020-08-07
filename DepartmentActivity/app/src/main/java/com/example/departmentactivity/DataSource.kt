package com.example.departmentactivity

import com.example.departmentactivity.models.Department

class DataSource {
    companion object{

        fun createDataSet(): ArrayList<Department>{
            val list = ArrayList<Department>()
            list.add(
                Department(
                    "Sunny Soho Flat",
                    "$130",
                    "department1",
                    "per night"
                )
            )
            list.add(
                Department(
                    "SH5 Stunning Shoreditch High Street Studio",
                    "$107",
                    "department2",
                    "per night"
                )
            )

            list.add(
                Department(
                    "Cozy Victorian Apartment in Islington",
                    "$196",
                    "department3",
                    "per night"
                )
            )

            list.add(
                Department(
                    "Urban Dream",
                    "$128",
                    "department4",
                    "per night"
                )
            )
            return list
        }
    }
}