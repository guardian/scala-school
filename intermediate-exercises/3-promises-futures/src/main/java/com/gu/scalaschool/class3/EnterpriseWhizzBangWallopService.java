package com.gu.scalaschool.class3;

import java.util.concurrent.Future;

interface EnterpriseWhizzBangWallopService {
    Future<WhizzBangWallop> requestWhizzBangWallop(AsyncHandler<WhizzBangWallop> handler);
}
