function sanitizeInput(input: string, maxLength: number = 200): string {
    // Basic trimming and length restriction
    let cleaned = input.trim().substring(0, maxLength);

    // Map of characters to escape
    // Using a Record for type-safe dictionary lookup
    const htmlEscapes: Record<string, string> = {
        '&': '&amp;',
        '<': '&lt;',
        '>': '&gt;',
        '"': '&quot;',
        "'": '&#39;',
    };

    // Use Regex with a replacement function
    // /[&<>"']/g finds all occurrences of these characters
    return cleaned.replace(/[&<>"']/g, (char) => htmlEscapes[char] || char);
}

export { sanitizeInput };