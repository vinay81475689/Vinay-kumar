interface Book {
    title: string;
    readonly author: string; // Required
    year?: number;           // Optional
}

let onepiece: Book = {
    title: "One Piece",
    author: "Eiichiro Oda",
    year: 1997
};

let books: Book[] = [
    { 
        title: "Angel Down", 
        author: "Lady Gaga" // Fixed: Added required author property
    }
];

export type{ Book };
