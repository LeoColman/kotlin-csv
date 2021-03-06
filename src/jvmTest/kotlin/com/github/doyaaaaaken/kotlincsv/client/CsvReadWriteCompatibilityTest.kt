package com.github.doyaaaaaken.kotlincsv.client

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.File


class CsvReadWriteCompatibilityTest : StringSpec({

    val testFileName = "compatibility-test.csv"

    afterTest { File(testFileName).delete() }

    "CSVReader and CSVWriter are compatible" {
        val data = listOf(
            listOf("a", "bb", "ccc"),
            listOf("d", "ee", "fff")
        )
        csvWriter().open(testFileName) {
            writeRows(data)
        }
        val actual = csvReader().readAll(File(testFileName))
        actual shouldBe data
    }
})
