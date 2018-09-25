package com.martin.app;

import java.util.*;

/**
 * Created by icenofox on 25/06/15.
 */

interface FindCommonAncestor {
    String findCommmonAncestor(String[] commitHashes, String[][] parentHashes, String commitHash1, String commitHash2);
}

public class MyFindCommonAncestor implements FindCommonAncestor {
    public String findCommmonAncestor(String[] commitHashes,
                                      String[][] parentHashes, String commitHash1, String commitHash2) {

        if (null == commitHashes || 0 == commitHashes.length ||
                null == parentHashes || 0 == parentHashes.length ||
                null == commitHash1 || null == commitHash2) {
            return null;
        }
        if (commitHash1.equals(commitHash2)) {
            return commitHash1;
        }

        boolean foundCommit1 = false;
        boolean foundCommit2 = false;

        Set<String> commit1Ancestors = Collections.emptySet();
        Set<String> commit2Ancestors = Collections.emptySet();

        for (int i = 0; i < commitHashes.length; i++) {
            String commitHash = commitHashes[i];
            String[] parents = parentHashes[i];
            List<String> parentsList = (parents == null ? null : Arrays
                    .asList(parents));
            if (!foundCommit1 && commitHash1.equals(commitHash)) {

                if (parents != null) {
                    commit1Ancestors = new HashSet<String>(parentsList);
                    commit1Ancestors.add(commitHash1);
                } else {
                    return null;
                }
                foundCommit1 = true;
            }
            if (!foundCommit2 && commitHash2.equals(commitHash)) {

                if (parents != null) {
                    commit2Ancestors = new HashSet<String>(parentsList);
                    commit2Ancestors.add(commitHash2);
                } else {
                    return null;
                }
                foundCommit2 = true;
            }

            if (!foundCommit1 && !foundCommit2) {
                continue;
            }

            if (commit1Ancestors.contains(commitHash)
                    && commit2Ancestors.contains(commitHash)) {

                return commitHash;
            }

            if (null != parentsList) {

                if (commit1Ancestors.remove(commitHash)) {
                    commit1Ancestors.addAll(parentsList);
                }
                if (commit2Ancestors.remove(commitHash)) {
                    commit2Ancestors.addAll(parentsList);
                }
            }
        }
        // scanned through all input without finding common ancestor.
        return null;
    }

    public static void main(String[] args) {

        String[] commits = {"H", "G", "F", "E", "D", "C", "B", "A"};
        String[][] parents = {{"C"}, {"F", "D"}, {"E"}, {"B"}, {"C"}, {"B"},
                {"A"}, null};

        String commit1 = "H";
        String commit2 = "F";


        MyFindCommonAncestor myFindCommonAncestor = new MyFindCommonAncestor();

        System.out.println("Common Ancestor is "
                + myFindCommonAncestor.findCommmonAncestor(commits, parents, commit1,
                commit2));
    }

}
