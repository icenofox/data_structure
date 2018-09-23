package com.pajk.DataStruct;

/**
 * Created by icenofox on 25/06/15.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyFlattenTree<T> implements FlattenTree<T> {

    private void _flattenInOrder(Tree<T> tree, final List<T> result) {
        Either<T, Triple<Tree<T>>> either = tree.get();
        if (null == either) {
            return;
        }
        if (either.isLeft()) {


            Object o = either.ifLeft(new Function<T, Object>() {
                @Override
                public Object apply(T t) {

                    if (null == t) {
                        return null;
                    }

                    if (t instanceof Tree.Node) {
                        _flattenInOrder((Tree.Node) t, result);
                        return null;
                    } else if (t instanceof Tree.Leaf) {
                        return ((Tree.Leaf) t).get().ifLeft(new Function() {
                            @Override
                            public Object apply(Object o) {
                                if (null == o) {
                                    return null;
                                }
                                return o;
                            }
                        });
                    }


                    return null;
                }
            });

            if (null != o){
                result.add((T) o);
            }
        } else {
            either.ifRight(new Function<Triple<Tree<T>>, Object>() {
                @Override
                public Object apply(Triple<Tree<T>> treeTriple) {
                    _flattenInOrder(treeTriple.left(), result);
                    _flattenInOrder(treeTriple.middle(), result);
                    _flattenInOrder(treeTriple.right(), result);
                    return null;
                }
            });
        }
    }

    public List<T> flattenInOrder(Tree<T> tree) {

        if (null == tree) {
            throw new IllegalArgumentException();
        }

        List<T> result = new ArrayList<T>();


        _flattenInOrder(tree, result);

        return result;
    }

    static class Node {
        private String value;
        private Node next;


        private String [] aa;
    }

    public static void main(String[] args) {


        Tree a2 = Tree.Node.tree(Tree.Leaf.leaf(5), Tree.Leaf.leaf(4), Tree.Leaf.leaf(9));
        Tree root = Tree.Node.tree(Tree.Leaf.leaf(1), a2, Tree.Leaf.leaf(6));

        MyFlattenTree<Integer> myFlattenTree = new MyFlattenTree<Integer>();


        HashMap a = new HashMap();


       boolean ret =  myFlattenTree.Test();

        System.out.println("Result order is " + myFlattenTree.flattenInOrder(root));

    }

    private boolean Test (){
        try {

            return true;
        }
        catch (Exception e)
        {

        }
        finally {
            return false;
        }
    }

}
