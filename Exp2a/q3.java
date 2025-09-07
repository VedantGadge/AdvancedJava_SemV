
// Capability to read posts
interface Readable {
    void readPost(int postId);
}

// Capability to write and edit posts
interface Writable {
    void createPost(String content);
    void editPost(int postId, String newContent);
}

// Capability to moderate posts
interface Moderatable {
    void blockPost(int postId);
}



class Reader implements Readable {
    @Override
    public void readPost(int postId) {
        System.out.println("Reader is reading post " + postId);
    }
}

class Writer implements Readable, Writable {
    @Override
    public void readPost(int postId) {
        System.out.println("Writer is reading post " + postId);
    }

    @Override
    public void createPost(String content) {
        System.out.println("Writer is creating a new post.");
    }

    @Override
    public void editPost(int postId, String newContent) {
        System.out.println("Writer is editing post " + postId);
    }
}

class Admin implements Readable, Writable, Moderatable {
    @Override
    public void readPost(int postId) {
        System.out.println("Admin is reading post " + postId);
    }

    @Override
    public void createPost(String content) {
        System.out.println("Admin is creating a new post.");
    }

    @Override
    public void editPost(int postId, String newContent) {
        System.out.println("Admin is editing post " + postId);
    }

    @Override
    public void blockPost(int postId) {
        System.out.println("Admin is blocking post " + postId);
    }
}