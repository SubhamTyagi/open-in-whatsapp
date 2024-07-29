package com.github.ialokim.phonefield;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Countries {

    public static final Map<Integer,List<Country>> COUNTRIES = new HashMap<>();
    static {
        COUNTRIES.put(1, Arrays.asList(
            new Country("as", 1, false, Collections.singletonList("684")),
            new Country("ai", 1, false, Collections.singletonList("264")),
            new Country("ag", 1, false, Collections.singletonList("268")),
            new Country("bs", 1, false, Collections.singletonList("242")),
            new Country("bb", 1, false, Collections.singletonList("246")),
            new Country("bm", 1, false, Collections.singletonList("441")),
            new Country("vg", 1, false, Collections.singletonList("284")),
            new Country("ca", 1, false, Arrays.asList(
                "204",
                "226",
                "236",
                "249",
                "250",
                "263",
                "289",
                "306",
                "343",
                "354",
                "365",
                "367",
                "368",
                "382",
                "387",
                "403",
                "416",
                "418",
                "428",
                "431",
                "437",
                "438",
                "450",
                "468",
                "474",
                "506",
                "514",
                "519",
                "548",
                "579",
                "581",
                "584",
                "587",
                "604",
                "613",
                "639",
                "647",
                "672",
                "683",
                "705",
                "709",
                "742",
                "753",
                "778",
                "780",
                "782",
                "807",
                "819",
                "825",
                "867",
                "873",
                "879",
                "902",
                "905",
                "942"
            )),
            new Country("ky", 1, false, Collections.singletonList("345")),
            new Country("dm", 1, false, Collections.singletonList("767")),
            new Country("do", 1, false, Arrays.asList(
                "809",
                "829",
                "849"
            )),
            new Country("gd", 1, false, Collections.singletonList("473")),
            new Country("gu", 1, false, Collections.singletonList("671")),
            new Country("jm", 1, false, Arrays.asList(
                "658",
                "876"
            )),
            new Country("ms", 1, false, Collections.singletonList("664")),
            new Country("mp", 1, false, Collections.singletonList("670")),
            new Country("pr", 1, false, Arrays.asList(
                "787",
                "939"
            )),
            new Country("kn", 1, false, Collections.singletonList("869")),
            new Country("lc", 1, false, Collections.singletonList("758")),
            new Country("vc", 1, false, Collections.singletonList("784")),
            new Country("sx", 1, false, Collections.singletonList("721")),
            new Country("tt", 1, false, Collections.singletonList("868")),
            new Country("tc", 1, false, Collections.singletonList("649")),
            new Country("vi", 1, false, Collections.singletonList("340")),
            new Country("us", 1, true, Arrays.asList(
                "201",
                "202",
                "203",
                "205",
                "206",
                "207",
                "208",
                "209",
                "210",
                "212",
                "213",
                "214",
                "215",
                "216",
                "217",
                "218",
                "219",
                "220",
                "223",
                "224",
                "225",
                "227",
                "228",
                "229",
                "231",
                "234",
                "239",
                "240",
                "248",
                "250",
                "251",
                "252",
                "253",
                "254",
                "256",
                "260",
                "262",
                "267",
                "269",
                "270",
                "272",
                "274",
                "276",
                "279",
                "281",
                "301",
                "302",
                "303",
                "304",
                "305",
                "307",
                "308",
                "309",
                "310",
                "312",
                "313",
                "314",
                "315",
                "316",
                "317",
                "318",
                "319",
                "320",
                "321",
                "323",
                "325",
                "326",
                "327",
                "330",
                "331",
                "332",
                "334",
                "336",
                "337",
                "339",
                "341",
                "346",
                "347",
                "351",
                "352",
                "360",
                "361",
                "364",
                "380",
                "385",
                "386",
                "401",
                "402",
                "404",
                "405",
                "406",
                "407",
                "408",
                "409",
                "410",
                "412",
                "413",
                "414",
                "415",
                "417",
                "419",
                "423",
                "424",
                "425",
                "430",
                "432",
                "434",
                "435",
                "440",
                "442",
                "443",
                "445",
                "447",
                "458",
                "463",
                "464",
                "469",
                "470",
                "475",
                "478",
                "479",
                "480",
                "484",
                "501",
                "502",
                "503",
                "504",
                "505",
                "507",
                "508",
                "509",
                "510",
                "512",
                "513",
                "515",
                "516",
                "517",
                "518",
                "520",
                "530",
                "531",
                "534",
                "539",
                "540",
                "541",
                "551",
                "559",
                "561",
                "562",
                "563",
                "564",
                "567",
                "570",
                "571",
                "573",
                "574",
                "575",
                "580",
                "585",
                "586",
                "601",
                "602",
                "603",
                "605",
                "606",
                "607",
                "608",
                "609",
                "610",
                "612",
                "614",
                "615",
                "616",
                "617",
                "618",
                "619",
                "620",
                "623",
                "626",
                "628",
                "629",
                "630",
                "631",
                "636",
                "640",
                "641",
                "646",
                "650",
                "651",
                "657",
                "659",
                "660",
                "661",
                "662",
                "667",
                "669",
                "678",
                "680",
                "681",
                "682",
                "689",
                "701",
                "702",
                "703",
                "704",
                "706",
                "707",
                "708",
                "712",
                "713",
                "714",
                "715",
                "716",
                "717",
                "718",
                "719",
                "720",
                "724",
                "725",
                "726",
                "727",
                "730",
                "731",
                "732",
                "734",
                "737",
                "740",
                "743",
                "747",
                "754",
                "757",
                "760",
                "762",
                "763",
                "765",
                "769",
                "770",
                "772",
                "773",
                "774",
                "775",
                "779",
                "781",
                "785",
                "786",
                "801",
                "802",
                "803",
                "804",
                "805",
                "806",
                "808",
                "810",
                "812",
                "813",
                "814",
                "815",
                "816",
                "817",
                "818",
                "820",
                "828",
                "830",
                "831",
                "832",
                "838",
                "843",
                "845",
                "847",
                "848",
                "850",
                "854",
                "856",
                "857",
                "858",
                "859",
                "860",
                "862",
                "863",
                "864",
                "865",
                "870",
                "872",
                "878",
                "901",
                "903",
                "904",
                "906",
                "907",
                "908",
                "910",
                "912",
                "913",
                "914",
                "915",
                "917",
                "918",
                "919",
                "920",
                "928",
                "929",
                "930",
                "931",
                "934",
                "936",
                "937",
                "938",
                "940",
                "941",
                "947",
                "952",
                "954",
                "956",
                "959",
                "970",
                "971",
                "972",
                "973",
                "978",
                "979",
                "980",
                "984",
                "985",
                "986",
                "989"
            ))
        ));
        COUNTRIES.put(7, Arrays.asList(
            new Country("kz", 7, false, Arrays.asList(
                "6",
                "7"
            )),
            new Country("ru", 7, true)
        ));
        COUNTRIES.put(20, Collections.singletonList(new Country("eg", 20, true)));
        COUNTRIES.put(27, Collections.singletonList(new Country("za", 27, true)));
        COUNTRIES.put(30, Collections.singletonList(new Country("gr", 30, true)));
        COUNTRIES.put(31, Collections.singletonList(new Country("nl", 31, true)));
        COUNTRIES.put(32, Collections.singletonList(new Country("be", 32, true)));
        COUNTRIES.put(33, Collections.singletonList(new Country("fr", 33, true)));
        COUNTRIES.put(34, Collections.singletonList(new Country("es", 34, true)));
        COUNTRIES.put(36, Collections.singletonList(new Country("hu", 36, true)));
        COUNTRIES.put(39, Arrays.asList(
            new Country("va", 39, false, Collections.singletonList("06698")),
            new Country("it", 39, true)
        ));
        COUNTRIES.put(40, Collections.singletonList(new Country("ro", 40, true)));
        COUNTRIES.put(41, Collections.singletonList(new Country("ch", 41, true)));
        COUNTRIES.put(43, Collections.singletonList(new Country("at", 43, true)));
        COUNTRIES.put(44, Arrays.asList(
            new Country("gg", 44, false, Arrays.asList(
                "1481",
                "7781",
                "7839",
                "7911"
            )),
            new Country("im", 44, false, Arrays.asList(
                "1624",
                "7524",
                "7624",
                "7924"
            )),
            new Country("je", 44, false, Collections.singletonList("1534")),
            new Country("gb", 44, true)
        ));
        COUNTRIES.put(45, Collections.singletonList(new Country("dk", 45, true)));
        COUNTRIES.put(46, Collections.singletonList(new Country("se", 46, true)));
        COUNTRIES.put(47, Arrays.asList(
            new Country("sj", 47, false, Collections.singletonList("79")),
            new Country("no", 47, true)
        ));
        COUNTRIES.put(48, Collections.singletonList(new Country("pl", 48, true)));
        COUNTRIES.put(49, Collections.singletonList(new Country("de", 49, true)));
        COUNTRIES.put(51, Collections.singletonList(new Country("pe", 51, true)));
        COUNTRIES.put(52, Collections.singletonList(new Country("mx", 52, true)));
        COUNTRIES.put(53, Collections.singletonList(new Country("cu", 53, true)));
        COUNTRIES.put(54, Collections.singletonList(new Country("ar", 54, true)));
        COUNTRIES.put(55, Collections.singletonList(new Country("br", 55, true)));
        COUNTRIES.put(56, Collections.singletonList(new Country("cl", 56, true)));
        COUNTRIES.put(57, Collections.singletonList(new Country("co", 57, true)));
        COUNTRIES.put(58, Collections.singletonList(new Country("ve", 58, true)));
        COUNTRIES.put(60, Collections.singletonList(new Country("my", 60, true)));
        COUNTRIES.put(61, Arrays.asList(
            new Country("cx", 61, false, Collections.singletonList("89164")),
            new Country("cc", 61, false, Collections.singletonList("89162")),
            new Country("au", 61, true)
        ));
        COUNTRIES.put(62, Collections.singletonList(new Country("id", 62, true)));
        COUNTRIES.put(63, Collections.singletonList(new Country("ph", 63, true)));
        COUNTRIES.put(64, Collections.singletonList(new Country("nz", 64, true)));
        COUNTRIES.put(65, Collections.singletonList(new Country("sg", 65, true)));
        COUNTRIES.put(66, Collections.singletonList(new Country("th", 66, true)));
        COUNTRIES.put(81, Collections.singletonList(new Country("jp", 81, true)));
        COUNTRIES.put(82, Collections.singletonList(new Country("kr", 82, true)));
        COUNTRIES.put(84, Collections.singletonList(new Country("vn", 84, true)));
        COUNTRIES.put(86, Collections.singletonList(new Country("cn", 86, true)));
        COUNTRIES.put(90, Collections.singletonList(new Country("tr", 90, true)));
        COUNTRIES.put(91, Collections.singletonList(new Country("in", 91, true)));
        COUNTRIES.put(92, Collections.singletonList(new Country("pk", 92, true)));
        COUNTRIES.put(93, Collections.singletonList(new Country("af", 93, true)));
        COUNTRIES.put(94, Collections.singletonList(new Country("lk", 94, true)));
        COUNTRIES.put(95, Collections.singletonList(new Country("mm", 95, true)));
        COUNTRIES.put(98, Collections.singletonList(new Country("ir", 98, true)));
        COUNTRIES.put(211, Collections.singletonList(new Country("ss", 211, true)));
        COUNTRIES.put(212, Arrays.asList(
            new Country("eh", 212, false),
            new Country("ma", 212, true)
        ));
        COUNTRIES.put(213, Collections.singletonList(new Country("dz", 213, true)));
        COUNTRIES.put(216, Collections.singletonList(new Country("tn", 216, true)));
        COUNTRIES.put(218, Collections.singletonList(new Country("ly", 218, true)));
        COUNTRIES.put(220, Collections.singletonList(new Country("gm", 220, true)));
        COUNTRIES.put(221, Collections.singletonList(new Country("sn", 221, true)));
        COUNTRIES.put(222, Collections.singletonList(new Country("mr", 222, true)));
        COUNTRIES.put(223, Collections.singletonList(new Country("ml", 223, true)));
        COUNTRIES.put(224, Collections.singletonList(new Country("gn", 224, true)));
        COUNTRIES.put(225, Collections.singletonList(new Country("ci", 225, true)));
        COUNTRIES.put(226, Collections.singletonList(new Country("bf", 226, true)));
        COUNTRIES.put(227, Collections.singletonList(new Country("ne", 227, true)));
        COUNTRIES.put(228, Collections.singletonList(new Country("tg", 228, true)));
        COUNTRIES.put(229, Collections.singletonList(new Country("bj", 229, true)));
        COUNTRIES.put(230, Collections.singletonList(new Country("mu", 230, true)));
        COUNTRIES.put(231, Collections.singletonList(new Country("lr", 231, true)));
        COUNTRIES.put(232, Collections.singletonList(new Country("sl", 232, true)));
        COUNTRIES.put(233, Collections.singletonList(new Country("gh", 233, true)));
        COUNTRIES.put(234, Collections.singletonList(new Country("ng", 234, true)));
        COUNTRIES.put(235, Collections.singletonList(new Country("td", 235, true)));
        COUNTRIES.put(236, Collections.singletonList(new Country("cf", 236, true)));
        COUNTRIES.put(237, Collections.singletonList(new Country("cm", 237, true)));
        COUNTRIES.put(238, Collections.singletonList(new Country("cv", 238, true)));
        COUNTRIES.put(239, Collections.singletonList(new Country("st", 239, true)));
        COUNTRIES.put(240, Collections.singletonList(new Country("gq", 240, true)));
        COUNTRIES.put(241, Collections.singletonList(new Country("ga", 241, true)));
        COUNTRIES.put(242, Collections.singletonList(new Country("cg", 242, true)));
        COUNTRIES.put(243, Collections.singletonList(new Country("cd", 243, true)));
        COUNTRIES.put(244, Collections.singletonList(new Country("ao", 244, true)));
        COUNTRIES.put(245, Collections.singletonList(new Country("gw", 245, true)));
        COUNTRIES.put(246, Collections.singletonList(new Country("io", 246, true)));
        COUNTRIES.put(248, Collections.singletonList(new Country("sc", 248, true)));
        COUNTRIES.put(249, Collections.singletonList(new Country("sd", 249, true)));
        COUNTRIES.put(250, Collections.singletonList(new Country("rw", 250, true)));
        COUNTRIES.put(251, Collections.singletonList(new Country("et", 251, true)));
        COUNTRIES.put(252, Collections.singletonList(new Country("so", 252, true)));
        COUNTRIES.put(253, Collections.singletonList(new Country("dj", 253, true)));
        COUNTRIES.put(254, Collections.singletonList(new Country("ke", 254, true)));
        COUNTRIES.put(255, Collections.singletonList(new Country("tz", 255, true)));
        COUNTRIES.put(256, Collections.singletonList(new Country("ug", 256, true)));
        COUNTRIES.put(257, Collections.singletonList(new Country("bi", 257, true)));
        COUNTRIES.put(258, Collections.singletonList(new Country("mz", 258, true)));
        COUNTRIES.put(260, Collections.singletonList(new Country("zm", 260, true)));
        COUNTRIES.put(261, Collections.singletonList(new Country("mg", 261, true)));
        COUNTRIES.put(262, Arrays.asList(
            new Country("yt", 262, false, Arrays.asList(
                "269",
                "639"
            )),
            new Country("re", 262, true)
        ));
        COUNTRIES.put(263, Collections.singletonList(new Country("zw", 263, true)));
        COUNTRIES.put(264, Collections.singletonList(new Country("na", 264, true)));
        COUNTRIES.put(265, Collections.singletonList(new Country("mw", 265, true)));
        COUNTRIES.put(266, Collections.singletonList(new Country("ls", 266, true)));
        COUNTRIES.put(267, Collections.singletonList(new Country("bw", 267, true)));
        COUNTRIES.put(268, Collections.singletonList(new Country("sz", 268, true)));
        COUNTRIES.put(269, Collections.singletonList(new Country("km", 269, true)));
        COUNTRIES.put(290, Collections.singletonList(new Country("sh", 290, true)));
        COUNTRIES.put(291, Collections.singletonList(new Country("er", 291, true)));
        COUNTRIES.put(297, Collections.singletonList(new Country("aw", 297, true)));
        COUNTRIES.put(298, Collections.singletonList(new Country("fo", 298, true)));
        COUNTRIES.put(299, Collections.singletonList(new Country("gl", 299, true)));
        COUNTRIES.put(350, Collections.singletonList(new Country("gi", 350, true)));
        COUNTRIES.put(351, Collections.singletonList(new Country("pt", 351, true)));
        COUNTRIES.put(352, Collections.singletonList(new Country("lu", 352, true)));
        COUNTRIES.put(353, Collections.singletonList(new Country("ie", 353, true)));
        COUNTRIES.put(354, Collections.singletonList(new Country("is", 354, true)));
        COUNTRIES.put(355, Collections.singletonList(new Country("al", 355, true)));
        COUNTRIES.put(356, Collections.singletonList(new Country("mt", 356, true)));
        COUNTRIES.put(357, Collections.singletonList(new Country("cy", 357, true)));
        COUNTRIES.put(358, Arrays.asList(
            new Country("ax", 358, false, Collections.singletonList("18")),
            new Country("fi", 358, true)
        ));
        COUNTRIES.put(359, Collections.singletonList(new Country("bg", 359, true)));
        COUNTRIES.put(370, Collections.singletonList(new Country("lt", 370, true)));
        COUNTRIES.put(371, Collections.singletonList(new Country("lv", 371, true)));
        COUNTRIES.put(372, Collections.singletonList(new Country("ee", 372, true)));
        COUNTRIES.put(373, Collections.singletonList(new Country("md", 373, true)));
        COUNTRIES.put(374, Collections.singletonList(new Country("am", 374, true)));
        COUNTRIES.put(375, Collections.singletonList(new Country("by", 375, true)));
        COUNTRIES.put(376, Collections.singletonList(new Country("ad", 376, true)));
        COUNTRIES.put(377, Collections.singletonList(new Country("mc", 377, true)));
        COUNTRIES.put(378, Collections.singletonList(new Country("sm", 378, true)));
        COUNTRIES.put(380, Collections.singletonList(new Country("ua", 380, true)));
        COUNTRIES.put(381, Collections.singletonList(new Country("rs", 381, true)));
        COUNTRIES.put(382, Collections.singletonList(new Country("me", 382, true)));
        COUNTRIES.put(385, Collections.singletonList(new Country("hr", 385, true)));
        COUNTRIES.put(386, Collections.singletonList(new Country("si", 386, true)));
        COUNTRIES.put(387, Collections.singletonList(new Country("ba", 387, true)));
        COUNTRIES.put(389, Collections.singletonList(new Country("mk", 389, true)));
        COUNTRIES.put(420, Collections.singletonList(new Country("cz", 420, true)));
        COUNTRIES.put(421, Collections.singletonList(new Country("sk", 421, true)));
        COUNTRIES.put(423, Collections.singletonList(new Country("li", 423, true)));
        COUNTRIES.put(500, Collections.singletonList(new Country("fk", 500, true)));
        COUNTRIES.put(501, Collections.singletonList(new Country("bz", 501, true)));
        COUNTRIES.put(502, Collections.singletonList(new Country("gt", 502, true)));
        COUNTRIES.put(503, Collections.singletonList(new Country("sv", 503, true)));
        COUNTRIES.put(504, Collections.singletonList(new Country("hn", 504, true)));
        COUNTRIES.put(505, Collections.singletonList(new Country("ni", 505, true)));
        COUNTRIES.put(506, Collections.singletonList(new Country("cr", 506, true)));
        COUNTRIES.put(507, Collections.singletonList(new Country("pa", 507, true)));
        COUNTRIES.put(508, Collections.singletonList(new Country("pm", 508, true)));
        COUNTRIES.put(509, Collections.singletonList(new Country("ht", 509, true)));
        COUNTRIES.put(590, Arrays.asList(
            new Country("bl", 590, false),
            new Country("mf", 590, false),
            new Country("gp", 590, true)
        ));
        COUNTRIES.put(591, Collections.singletonList(new Country("bo", 591, true)));
        COUNTRIES.put(592, Collections.singletonList(new Country("gy", 592, true)));
        COUNTRIES.put(593, Collections.singletonList(new Country("ec", 593, true)));
        COUNTRIES.put(594, Collections.singletonList(new Country("gf", 594, true)));
        COUNTRIES.put(595, Collections.singletonList(new Country("py", 595, true)));
        COUNTRIES.put(596, Collections.singletonList(new Country("mq", 596, true)));
        COUNTRIES.put(597, Collections.singletonList(new Country("sr", 597, true)));
        COUNTRIES.put(598, Collections.singletonList(new Country("uy", 598, true)));
        COUNTRIES.put(599, Arrays.asList(
            new Country("cw", 599, false, Collections.singletonList("9")),
            new Country("bq", 599, true, Arrays.asList(
                "3",
                "4",
                "7"
            ))
        ));
        COUNTRIES.put(670, Collections.singletonList(new Country("tl", 670, true)));
        COUNTRIES.put(672, Collections.singletonList(new Country("nf", 672, true, Collections.singletonList("3"))));
        COUNTRIES.put(673, Collections.singletonList(new Country("bn", 673, true)));
        COUNTRIES.put(674, Collections.singletonList(new Country("nr", 674, true)));
        COUNTRIES.put(675, Collections.singletonList(new Country("pg", 675, true)));
        COUNTRIES.put(676, Collections.singletonList(new Country("to", 676, true)));
        COUNTRIES.put(677, Collections.singletonList(new Country("sb", 677, true)));
        COUNTRIES.put(678, Collections.singletonList(new Country("vu", 678, true)));
        COUNTRIES.put(679, Collections.singletonList(new Country("fj", 679, true)));
        COUNTRIES.put(680, Collections.singletonList(new Country("pw", 680, true)));
        COUNTRIES.put(681, Collections.singletonList(new Country("wf", 681, true)));
        COUNTRIES.put(682, Collections.singletonList(new Country("ck", 682, true)));
        COUNTRIES.put(683, Collections.singletonList(new Country("nu", 683, true)));
        COUNTRIES.put(685, Collections.singletonList(new Country("ws", 685, true)));
        COUNTRIES.put(686, Collections.singletonList(new Country("ki", 686, true)));
        COUNTRIES.put(687, Collections.singletonList(new Country("nc", 687, true)));
        COUNTRIES.put(688, Collections.singletonList(new Country("tv", 688, true)));
        COUNTRIES.put(689, Collections.singletonList(new Country("pf", 689, true)));
        COUNTRIES.put(690, Collections.singletonList(new Country("tk", 690, true)));
        COUNTRIES.put(691, Collections.singletonList(new Country("fm", 691, true)));
        COUNTRIES.put(692, Collections.singletonList(new Country("mh", 692, true)));
        COUNTRIES.put(850, Collections.singletonList(new Country("kp", 850, true)));
        COUNTRIES.put(852, Collections.singletonList(new Country("hk", 852, true)));
        COUNTRIES.put(853, Collections.singletonList(new Country("mo", 853, true)));
        COUNTRIES.put(855, Collections.singletonList(new Country("kh", 855, true)));
        COUNTRIES.put(856, Collections.singletonList(new Country("la", 856, true)));
        COUNTRIES.put(880, Collections.singletonList(new Country("bd", 880, true)));
        COUNTRIES.put(886, Collections.singletonList(new Country("tw", 886, true)));
        COUNTRIES.put(960, Collections.singletonList(new Country("mv", 960, true)));
        COUNTRIES.put(961, Collections.singletonList(new Country("lb", 961, true)));
        COUNTRIES.put(962, Collections.singletonList(new Country("jo", 962, true)));
        COUNTRIES.put(963, Collections.singletonList(new Country("sy", 963, true)));
        COUNTRIES.put(964, Collections.singletonList(new Country("iq", 964, true)));
        COUNTRIES.put(965, Collections.singletonList(new Country("kw", 965, true)));
        COUNTRIES.put(966, Collections.singletonList(new Country("sa", 966, true)));
        COUNTRIES.put(967, Collections.singletonList(new Country("ye", 967, true)));
        COUNTRIES.put(968, Collections.singletonList(new Country("om", 968, true)));
        COUNTRIES.put(970, Collections.singletonList(new Country("ps", 970, true)));
        COUNTRIES.put(971, Collections.singletonList(new Country("ae", 971, true)));
        COUNTRIES.put(972, Collections.singletonList(new Country("il", 972, true)));
        COUNTRIES.put(973, Collections.singletonList(new Country("bh", 973, true)));
        COUNTRIES.put(974, Collections.singletonList(new Country("qa", 974, true)));
        COUNTRIES.put(975, Collections.singletonList(new Country("bt", 975, true)));
        COUNTRIES.put(976, Collections.singletonList(new Country("mn", 976, true)));
        COUNTRIES.put(977, Collections.singletonList(new Country("np", 977, true)));
        COUNTRIES.put(992, Collections.singletonList(new Country("tj", 992, true)));
        COUNTRIES.put(993, Collections.singletonList(new Country("tm", 993, true)));
        COUNTRIES.put(994, Collections.singletonList(new Country("az", 994, true)));
        COUNTRIES.put(995, Collections.singletonList(new Country("ge", 995, true)));
        COUNTRIES.put(996, Collections.singletonList(new Country("kg", 996, true)));
        COUNTRIES.put(998, Collections.singletonList(new Country("uz", 998, true)));
    }

}
