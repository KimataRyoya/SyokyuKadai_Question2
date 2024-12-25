package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
  // 配列とリストまたはStreamAPIを使用して、学生の名前と点数を管理するプログラムを作成してください。
  // 名前の追加、削除、点数の更新、平均点の計算ができるようにしてください。
  // 処理をループさせるにはWhile文を使って実現してください。

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Map<String, Integer> students = new HashMap<>();

    while (true) {
      System.out.println("\n学生の点数管理システム:");
      System.out.println("1. 学生を追加");
      System.out.println("2. 学生を削除");
      System.out.println("3. 点数を更新");
      System.out.println("4. 平均点を計算");
      System.out.println("5. 学生一覧を表示");
      System.out.println("6. 終了");
      System.out.print("操作を選んでください: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // 改行を消費

      switch (choice) {
        case 1:
          System.out.print("学生の名前を入力してください: ");
          String nameToAdd = scanner.nextLine();
          if (students.containsKey(nameToAdd)) {
            System.out.println("この学生はすでに存在します。");
          } else {
            System.out.print("点数を入力してください: ");
            int scoreToAdd = scanner.nextInt();
            scanner.nextLine(); // 改行を消費
            students.put(nameToAdd, scoreToAdd);
            System.out.println("学生が追加されました。");
          }
          break;

        case 2:
          System.out.print("削除する学生の名前を入力してください: ");
          String nameToRemove = scanner.nextLine();
          if (students.containsKey(nameToRemove)) {
            students.remove(nameToRemove);
            System.out.println("学生が削除されました。");
          } else {
            System.out.println("その名前の学生は存在しません。");
          }
          break;

        case 3:
          System.out.print("点数を更新する学生の名前を入力してください: ");
          String nameToUpdate = scanner.nextLine();
          if (students.containsKey(nameToUpdate)) {
            System.out.print("新しい点数を入力してください: ");
            int newScore = scanner.nextInt();
            scanner.nextLine(); // 改行を消費
            students.put(nameToUpdate, newScore);
            System.out.println("点数が更新されました。");
          } else {
            System.out.println("その名前の学生は存在しません。");
          }
          break;

        case 4:
          if (students.isEmpty()) {
            System.out.println("学生が登録されていません。");
          } else {
            double average = students.values().stream()
                .collect(Collectors.averagingDouble(Integer::doubleValue));
            System.out.println("平均点: " + average);
          }
          break;

        case 5:
          if (students.isEmpty()) {
            System.out.println("学生が登録されていません。");
          } else {
            System.out.println("学生一覧:");
            students.forEach(
                (name, score) -> System.out.println("名前: " + name + ", 点数: " + score));
          }
          break;

        case 6:
          System.out.println("システムを終了します。さようなら！");
          scanner.close();
          return;

        default:
          System.out.println("無効な選択です。再試行してください。");
      }
    }
  }
}
