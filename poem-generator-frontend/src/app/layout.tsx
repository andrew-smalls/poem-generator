import type { Metadata } from "next";
import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css";
import Header from "@/app/components/header/Header";
import CreatePoem from "@/app/components/header/CreatePoem";
import CountryPicker from "@/app/components/header/CountryPicker";
import Profile from "@/app/components/header/Profile";
import Footer from "@/app/components/footer/Footer";

const geistSans = Geist({
    variable: "--font-geist-sans",
    subsets: ["latin"],
});

const geistMono = Geist_Mono({
    variable: "--font-geist-mono",
    subsets: ["latin"],
});

export const metadata: Metadata = {
    title: "Poem Generator",
    description: "Where 'human' rhymes with 'machine'",
};

export default function RootLayout({
                                       children,
                                   }: {
    children: React.ReactNode;
}) {
    return (
        <html lang="en">
        <head>
            <title>Poem Generator</title>
        </head>
        <body className={`${geistSans.variable} ${geistMono.variable} antialiased bg-gray-50 text-gray-900`}>
        <Header>
            <CreatePoem />
            <CountryPicker />
            <Profile />
        </Header>

        <main className="min-h-screen">{children}</main>

        <Footer />
        </body>
        </html>
    );
}